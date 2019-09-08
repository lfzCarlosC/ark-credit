package com.cryptal.ark.arkcreditservice.user.eventhandler;

import com.cryptal.ark.arkcreditservice.common.EnumUtils;
import com.cryptal.ark.arkcreditservice.order.event.OrderCreated;
import com.cryptal.ark.arkcreditservice.user.event.UserRankAssigned;
import com.cryptal.ark.arkcreditservice.user.event.UserRankExpired;
import com.cryptal.ark.arkcreditservice.rank.domain.RankConstant;
import com.cryptal.ark.arkcreditservice.user.event.UserRegistered;
import com.cryptal.ark.arkcreditservice.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class UserEventHandler {

    @Autowired
    private UserService userService;

    /**
     * 监听会员已过期事件，已过期标记用户等级为普通用户
     * @param event
     */
    @EventListener
    public void handle(UserRankExpired event){
        userService.changeRank(event.getUserId(), RankConstant.NORMAL_USER);
    }

    @EventListener
    public void handle(UserRankAssigned event){
        userService.changeRank(event.getUserId(), EnumUtils.getEnumBycode(RankConstant.class,event.getRankId().intValue()));
    }

    /**
     * 用户注册，用户送积分
     * @param event
     */
    @EventListener
    public void handle(UserRegistered event){
        userService.handleUserRegister(event);
    }

    /**
     * 用户下单，下单用户扣减积分，用户的邀请者获得积分
     * @param event
     */
    @EventListener
    public void handle(OrderCreated event){
        userService.handleOrderCreated(event);
    }
}
