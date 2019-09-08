package com.cryptal.ark.arkcreditservice.member.eventhandler;

import com.cryptal.ark.arkcreditservice.rank.domain.RankConstant;
import com.cryptal.ark.arkcreditservice.user.event.UserRankExpired;
import com.cryptal.ark.arkcreditservice.member.service.MemberRankService;
import com.cryptal.ark.arkcreditservice.user.event.UserRegistered;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MemberEventHandler {

    @Autowired
    private MemberRankService memberRankService;

    @EventListener
    public void handle(UserRankExpired userRankExpired){
        memberRankService.removeMember(userRankExpired.getUserId());
    }

    /**
     * 新注册用户，三天普通用户
     * @param event
     */
    @EventListener
    public void handle(UserRegistered event){
        memberRankService.addMember(event.getUserId(), RankConstant.NORMAL_USER);
    }

}
