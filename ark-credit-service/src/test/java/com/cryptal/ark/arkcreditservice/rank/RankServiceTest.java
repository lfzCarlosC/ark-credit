package com.cryptal.ark.arkcreditservice.rank;

import com.cryptal.ark.arkcreditservice.member.service.MemberRankService;
import com.cryptal.ark.arkcreditservice.member.service.impl.MemberRankServiceImpl;
import com.cryptal.ark.arkcreditservice.rank.domain.Rank;
import com.cryptal.ark.arkcreditservice.rank.service.RankMessageTypeService;
import com.cryptal.ark.arkcreditservice.rank.service.RankService;
import com.cryptal.ark.arkcreditservice.rank.service.impl.RankMessageTypeServiceImpl;
import com.cryptal.ark.arkcreditservice.rank.service.impl.RankServiceImpl;
import org.junit.Test;

public class RankServiceTest {

    private RankMessageTypeService rankMessageTypeService = new RankMessageTypeServiceImpl();

    private RankService rankService = new RankServiceImpl();

    private MemberRankService memberRankService = new MemberRankServiceImpl();

    /**
     * 用例：增加新的等级
     */
    @Test
    public void test_add_new_rank(){
        Rank rank = new Rank();
        rank.setName("黄金会员");
        rankService.insert(rank);
    }

    /**
     * 用例：绑定等级和消息类型的关系
     */
    @Test
    public void test_bind_rank_messageType(){

        Long rankId = 0L;
        Long messageTypeId= 0L;
        rankMessageTypeService.bindRankWithMessageType(rankId,messageTypeId);

    }


}
