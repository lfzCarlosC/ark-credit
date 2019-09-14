package com.cryptal.ark.arkcreditservice.user.service.impl;

import com.cryptal.ark.arkcreditservice.common.exp.CreditException;
import com.cryptal.ark.arkcreditservice.order.event.OrderCreated;
import com.cryptal.ark.arkcreditservice.rank.domain.RankConstant;
import com.cryptal.ark.arkcreditservice.rank.service.MemberRankService;
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
import java.util.Optional;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private ApplicationEventPublisher publisher;

    @Autowired
    private MemberRankService memberRankService;

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
        Optional<User> userOption = userDao.findById(event.getUserId());

        if(!userOption.isPresent()){
            throw new CreditException("下单用户ID不存在，userId=" + event.getUserId());
        }

        User user = userOption.get();
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
        Optional<User> inviteUserOption = userDao.findById(inviteUserId);
        if (!inviteUserOption.isPresent()) {
            throw new CreditException("下单用户的邀请用户ID不存在，userId=" + inviteUserId);
        }
        User invitedUser = inviteUserOption.get();
        int rebatePercent = memberRankService.computeRebatePercent(invitedUser.getRankId(), level);
        BigDecimal rebateAmount = paymentAmount.multiply(new BigDecimal(rebatePercent / 100));
        invitedUser.setBalance(invitedUser.getBalance().add(rebateAmount));

        publisher.publishEvent(new UserAmountAdded(this, invitedUser.getId(), rebateAmount, "邀请用户付款赠予积分"));
    }

    private User constructUser(RegisterUserRequest request) {
        return new User();
    }


}
