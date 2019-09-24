package com.cryptal.ark.arkcreditservice.user.service.impl;

import com.cryptal.ark.arkcreditservice.common.EncryptUtil;
import com.cryptal.ark.arkcreditservice.common.exp.CreditException;
import com.cryptal.ark.arkcreditservice.order.event.OrderCreated;
import com.cryptal.ark.arkcreditservice.rank.domain.RankConstant;
import com.cryptal.ark.arkcreditservice.member.service.RankService;
import com.cryptal.ark.arkcreditservice.user.dao.UserDao;
import com.cryptal.ark.arkcreditservice.user.domain.User;
import com.cryptal.ark.arkcreditservice.user.event.UserAmountAdded;
import com.cryptal.ark.arkcreditservice.user.event.UserBalanceReduced;
import com.cryptal.ark.arkcreditservice.user.event.UserRegistered;
import com.cryptal.ark.arkcreditservice.user.request.RegisterUserRequest;
import com.cryptal.ark.arkcreditservice.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private ApplicationEventPublisher publisher;

    @Autowired
    private RankService rankService;

    @Override
    public void register(RegisterUserRequest request) {

        User user = constructUser(request);

        userDao.save(user);

        publisher.publishEvent(new UserRegistered(this, user.getId(), user.getInviteUserId1()));

    }

    @Override
    public User getUserInfoById(Long userId) {
        return userDao.getOne(userId);
    }

    @Override
    public void changeRank(Long userId, RankConstant rankConstant) {

    }

    @Override
    public void handleUserRegister(UserRegistered event) {



    }

    @Override
    public void handleOrderCreated(OrderCreated event) {

        //购买用户本身扣积分
        User user = checkAndFindById(event.getUserId());
        user.setBalance(user.getBalance().subtract(event.getPaymentAmount()));
        userDao.save(user);
        publisher.publishEvent(new UserBalanceReduced(this,event.getUserId(),event.getPaymentAmount(),"下单扣减积分"));

        if(user.getInviteUserId1()!=0){
            handleInviteUser(event.getPaymentAmount(), user.getInviteUserId1(), 1);
        }

        if(user.getInviteUserId2()!=0){
            handleInviteUser(event.getPaymentAmount(), user.getInviteUserId2(), 2);
        }

        if(user.getInviteUserId3()!=0){
            handleInviteUser(event.getPaymentAmount(), user.getInviteUserId3(), 3);
        }

    }

    /**
     * 处理邀请用户
     * @param paymentAmount
     * @param inviteUserId
     * @param level
     */
    private void handleInviteUser(BigDecimal paymentAmount, Long inviteUserId, int level) {
        User invitedUser = checkAndFindById(inviteUserId);
        int rebatePercent = rankService.computeRebatePercent(invitedUser.getRankId(), level);
        BigDecimal rebateAmount = paymentAmount.multiply(new BigDecimal(rebatePercent / 100));
        invitedUser.setBalance(invitedUser.getBalance().add(rebateAmount));
        publisher.publishEvent(new UserAmountAdded(this, invitedUser.getId(), rebateAmount, "邀请用户付款赠予积分"));
    }

    /**
     * 根据用户ID获取用户信息
     * @param inviteUserId
     * @return
     */
    private User checkAndFindById(Long inviteUserId) {
        Optional<User> inviteUserOption = userDao.findById(inviteUserId);
        if (!inviteUserOption.isPresent()) {
            throw new CreditException("用户信息不存在：" + inviteUserId);
        }
        return inviteUserOption.get();
    }

    /**
     * 构造登录信息
     * @param request
     * @return
     */
    private User constructUser(RegisterUserRequest request) {
        User user = new User();
        user.setBalance(new BigDecimal(0));
        user.setUsername(request.getUsername());
        user.setInviteUserId1(request.getInvitedUserId());
        user.setPassword(EncryptUtil.md5(request.getPassword()));
        user.setCreateTime(new Date());

        if(request.getInvitedUserId()!=0){
            User inviteUser = checkAndFindById(request.getInvitedUserId());
            user.setInviteUserId2(inviteUser.getInviteUserId1());
            user.setInviteUserId3(inviteUser.getInviteUserId2());
        }

        return user;
    }


}
