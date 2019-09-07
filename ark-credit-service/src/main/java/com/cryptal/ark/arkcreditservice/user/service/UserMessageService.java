package com.cryptal.ark.arkcreditservice.user.service;

import com.cryptal.ark.arkcreditservice.credit.event.UserCreditAdded;
import com.cryptal.ark.arkcreditservice.user.event.UserExpired;

public interface UserMessageService {
    /**
     * 处理用户积分增加的消息
     * @param event
     */
    void receiveCreditAdded(UserCreditAdded event);

    /**
     * 处理用户会员过期的问题
     * @param event
     */
    void receiveUserExpired(UserExpired event);
}
