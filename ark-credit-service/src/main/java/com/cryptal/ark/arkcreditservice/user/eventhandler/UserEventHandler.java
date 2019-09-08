package com.cryptal.ark.arkcreditservice.user.eventhandler;

import com.cryptal.ark.arkcreditservice.member.event.MemberExpired;
import com.cryptal.ark.arkcreditservice.rank.domain.RankConstant;
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
    public void handle(MemberExpired event){
        userService.changeRank(event.getUserId(), RankConstant.NORMAL_USER);
    }

}
