package com.cryptal.ark.arkcreditservice.user.service;

import com.cryptal.ark.arkcreditservice.order.event.OrderCreated;
import com.cryptal.ark.arkcreditservice.rank.domain.RankConstant;
import com.cryptal.ark.arkcreditservice.user.domain.User;
import com.cryptal.ark.arkcreditservice.user.event.UserRegistered;
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
    User getUserInfoById(Long userId);

    /**
     * 更新用户等级
     * @param userId
     * @param rankConstant
     */
    void changeRank(Long userId, RankConstant rankConstant);

    /**
     * 处理用户已注册事件
     * @param event
     */
    void handleUserRegister(UserRegistered event);

    /**
     * 处理用户已下单事件
     * @param event
     */
    void handleOrderCreated(OrderCreated event);
}
