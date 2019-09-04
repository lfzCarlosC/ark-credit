package com.cryptal.ark.arkcreditservice.credit.service;

import com.cryptal.ark.arkcreditservice.user.event.UserRegistered;

public interface UserCreditService {

    /**
     * 处理新用户注册事件
     * 1. 初始化新用户积分
     * 2. 被邀请用户积分增加
     * @param event
     */
    void handleRegisterEvent(UserRegistered event);

}
