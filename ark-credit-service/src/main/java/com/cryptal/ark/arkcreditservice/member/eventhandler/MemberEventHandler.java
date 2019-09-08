package com.cryptal.ark.arkcreditservice.member.eventhandler;

import com.cryptal.ark.arkcreditservice.member.event.MemberExpired;
import com.cryptal.ark.arkcreditservice.member.service.MemberRankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MemberEventHandler {

    @Autowired
    private MemberRankService memberRankService;

    @EventListener
    public void handle(MemberExpired memberExpired){
        memberRankService.removeMember(memberExpired.getUserId());
    }

}
