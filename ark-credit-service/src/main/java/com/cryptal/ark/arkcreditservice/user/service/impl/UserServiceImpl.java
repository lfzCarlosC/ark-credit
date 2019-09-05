package com.cryptal.ark.arkcreditservice.user.service.impl;

import com.cryptal.ark.arkcreditservice.user.dao.UserRepository;
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
    private UserRepository userRepository;

    @Autowired
    private ApplicationEventPublisher publisher;

    @Override
    public void register(RegisterUserRequest request) {

        User user = constructUser(request);

        userRepository.save(user);

        publisher.publishEvent(new UserRegistered(this, user.getId(), user.getInviteUserId()));

    }

    @Override
    public User getUserInforById(Long userId) {
        return userRepository.getOne(userId);
    }

    private User constructUser(RegisterUserRequest request) {
        return new User();
    }


}
