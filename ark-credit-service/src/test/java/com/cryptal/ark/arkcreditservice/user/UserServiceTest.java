package com.cryptal.ark.arkcreditservice.user;

import com.cryptal.ark.arkcreditservice.user.request.RegisterUserRequest;
import com.cryptal.ark.arkcreditservice.user.service.UserService;
import com.cryptal.ark.arkcreditservice.user.service.impl.UserServiceImpl;

public class UserServiceTest {

    private UserService userService = new UserServiceImpl();

    /**
     * 用例一：用户注册
     */
    public void test_user_register(){

        RegisterUserRequest request = new RegisterUserRequest();

        userService.register(request);
    }


}
