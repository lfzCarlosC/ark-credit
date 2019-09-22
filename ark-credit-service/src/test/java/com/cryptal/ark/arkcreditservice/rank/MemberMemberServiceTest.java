package com.cryptal.ark.arkcreditservice.rank;

import com.cryptal.ark.arkcreditservice.member.entity.MemberRankEntity;
import com.cryptal.ark.arkcreditservice.member.service.MemberRankService;
import com.cryptal.ark.arkcreditservice.rank.service.RankMessageTypeService;
import com.cryptal.ark.arkcreditservice.member.service.impl.MemberRankServiceImpl;
import com.cryptal.ark.arkcreditservice.rank.service.impl.RankMessageTypeServiceImpl;
import org.junit.Test;

public class MemberMemberServiceTest {

    private RankMessageTypeService rankMessageTypeService = new RankMessageTypeServiceImpl();

    private MemberRankService memberRankService = new MemberRankServiceImpl();

    /**
     * 用例：创建修改，等级的佣金比例，价格
     */
    @Test
    public void test_add_new_rank(){
        MemberRankEntity memberRankEntity = new MemberRankEntity();
        memberRankEntity.setName("黄金会员");
        memberRankEntity.setRebatePercentLevel1(20);
        memberRankEntity.setRebatePercentLevel2(10);
        memberRankEntity.setRebatePercentLevel3(5);
        memberRankService.insert(memberRankEntity);
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
