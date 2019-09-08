package com.cryptal.ark.arkcreditservice.member;

import com.cryptal.ark.arkcreditservice.member.service.MemberRankService;
import com.cryptal.ark.arkcreditservice.member.service.impl.MemberRankServiceImpl;

public class MemberServiceTest {

    private MemberRankService memberRankService = new MemberRankServiceImpl();

    /**
     * 用例：定时器每晚移除过期用户
     */
    public void test_remove_user(){
        memberRankService.removeExpireMembers();
    }

}
