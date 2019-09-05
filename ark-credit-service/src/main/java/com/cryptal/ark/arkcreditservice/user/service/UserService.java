package com.cryptal.ark.arkcreditservice.user.service;

import com.cryptal.ark.arkcreditservice.user.domain.User;
import com.cryptal.ark.arkcreditservice.user.request.RegisterUserRequest;

public interface UserService {

    /**
     * 注册用户
     * @param request
     */
    void register(RegisterUserRequest request);

    /**
     * 显示用户信息
     * @param userId
     */
    User getUserInforById(Long userId);
}
