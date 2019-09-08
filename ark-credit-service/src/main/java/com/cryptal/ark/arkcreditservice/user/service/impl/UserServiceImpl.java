package com.cryptal.ark.arkcreditservice.user.service.impl;

import com.cryptal.ark.arkcreditservice.common.exp.CreditException;
import com.cryptal.ark.arkcreditservice.order.event.OrderCreated;
import com.cryptal.ark.arkcreditservice.rank.domain.RankConstant;
import com.cryptal.ark.arkcreditservice.user.dao.UserDao;
import com.cryptal.ark.arkcreditservice.user.domain.User;
import com.cryptal.ark.arkcreditservice.user.event.UserCreditAdded;
import com.cryptal.ark.arkcreditservice.user.event.UserCreditReduced;
import com.cryptal.ark.arkcreditservice.user.event.UserRegistered;
import com.cryptal.ark.arkcreditservice.user.request.RegisterUserRequest;
import com.cryptal.ark.arkcreditservice.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private ApplicationEventPublisher publisher;

    @Override
    public void register(RegisterUserRequest request) {

        User user = constructUser(request);

        userDao.save(user);

        publisher.publishEvent(new UserRegistered(this, user.getId(), user.getInviteUserId()));

    }

    @Override
    public User getUserInforById(Long userId) {
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

        Optional<User> userOption = userDao.findById(event.getUserId());

        if(!userOption.isPresent()){
            throw new CreditException("下单用户ID不存在，userId=" + event.getUserId());
        }

        User user = userOption.get();
        user.setCredit(user.getCredit()-event.getCredit());
        userDao.save(user);
        publisher.publishEvent(new UserCreditReduced(this,event.getUserId(),event.getCredit(),"下单扣减积分"));


        Optional<User> inviteUserOption = userDao.findById(user.getInviteUserId());
        if(!inviteUserOption.isPresent()){
            throw new CreditException("下单用户的邀请用户ID不存在，userId=" + user.getInviteUserId());
        }

        User inviteUser = inviteUserOption.get();
        inviteUser.setCredit(inviteUser.getCredit());
        userDao.save(inviteUser);
        publisher.publishEvent(new UserCreditAdded(this,inviteUser.getId(),event.getCredit(),"邀请的用户付款赠予积分"));

    }

    private User constructUser(RegisterUserRequest request) {
        return new User();
    }


}
