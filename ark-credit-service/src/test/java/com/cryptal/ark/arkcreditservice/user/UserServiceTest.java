package com.cryptal.ark.arkcreditservice.user;

import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.cryptal.ark.arkcreditservice.user.dao.UserRepository;
import com.cryptal.ark.arkcreditservice.user.domain.User;
import com.cryptal.ark.arkcreditservice.user.request.RegisterUserRequest;
import com.cryptal.ark.arkcreditservice.user.service.UserService;
import com.cryptal.ark.arkcreditservice.user.service.impl.UserServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    private UserService userService = new UserServiceImpl();

    @Mock
    private UserRepository userRepository;

    @Mock
    private User user;

    /**
     * 用例一：用户注册
     */
    public void test_user_register() {

        RegisterUserRequest request = new RegisterUserRequest();

        userService.register(request);
    }

    public void test_user_getUserInfo() {
        Long userId = 11L;
        String name = "testUser";
        when(userRepository.getOne(userId)).thenReturn(user);
        when(user.getId()).thenReturn(userId);
        when(user.getUsername()).thenReturn(name);
        userService.getUserInforById(userId);

    }

}
