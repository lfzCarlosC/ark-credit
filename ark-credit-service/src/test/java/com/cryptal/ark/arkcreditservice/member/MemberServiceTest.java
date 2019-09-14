package com.cryptal.ark.arkcreditservice.member;

import com.cryptal.ark.arkcreditservice.member.service.MemberService;
import com.cryptal.ark.arkcreditservice.member.service.impl.MemberServiceImpl;

public class MemberServiceTest {

    private MemberService memberService = new MemberServiceImpl();

    /**
     * 用例：定时器每晚移除过期用户
     */
    public void test_remove_user(){
        memberService.removeExpireMembers();
    }

}
