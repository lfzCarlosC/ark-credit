package com.cryptal.ark.arkcreditservice.user.service.impl;

import com.cryptal.ark.arkcreditservice.rank.domain.RankConstant;
import com.cryptal.ark.arkcreditservice.user.dao.UserDao;
import com.cryptal.ark.arkcreditservice.user.domain.User;
import com.cryptal.ark.arkcreditservice.user.event.UserRegistered;
import com.cryptal.ark.arkcreditservice.user.request.RegisterUserRequest;
import com.cryptal.ark.arkcreditservice.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

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

    private User constructUser(RegisterUserRequest request) {
        return new User();
    }


}
