package com.cryptal.ark.arkcreditservice.user.service;

import com.cryptal.ark.arkcreditservice.user.event.UserCreditAdded;
import com.cryptal.ark.arkcreditservice.order.event.OrderCreated;
import com.cryptal.ark.arkcreditservice.user.event.UserRankExpired;

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
    void receiveUserExpired(UserRankExpired event);

    /**
     * 处理下单事件
     * @param event
     */
    void receiveOrderCreated(OrderCreated event);

}
