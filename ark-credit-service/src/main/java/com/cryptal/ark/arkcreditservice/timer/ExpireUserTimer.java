package com.cryptal.ark.arkcreditservice.timer;

import com.cryptal.ark.arkcreditservice.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class ExpireUserTimer {

    @Autowired
    private MemberService memberService;

    @Autowired
    private ApplicationEventPublisher publisher;

    /**
     * 每天排除到期的会员，会员表中删除
     */
    public void expireMember(){

        memberService.removeExpireMembers();

    }

}
