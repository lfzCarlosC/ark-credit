package com.cryptal.ark.arkcreditservice.user.service;

import com.cryptal.ark.arkcreditservice.user.request.RegisterUserRequest;

public interface UserService {

    /**
     * 注册用户
     * @param request
     */
    void register(RegisterUserRequest request);
}
