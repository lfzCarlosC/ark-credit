package com.cryptal.ark.arkcreditservice.message.service;

import com.cryptal.ark.arkcreditservice.credit.event.UserCreditAdded;

public interface MessageService{
    /**
     * 处理用户积分增加的消息
     * @param event
     */
    void receiveCreditAdded(UserCreditAdded event);
}
