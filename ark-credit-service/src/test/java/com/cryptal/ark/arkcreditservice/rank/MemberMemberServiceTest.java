package com.cryptal.ark.arkcreditservice.rank;

import com.cryptal.ark.arkcreditservice.member.entity.RankEntity;
import com.cryptal.ark.arkcreditservice.member.service.RankService;
import com.cryptal.ark.arkcreditservice.rank.service.RankMessageTypeService;
import com.cryptal.ark.arkcreditservice.member.service.impl.RankServiceImpl;
import com.cryptal.ark.arkcreditservice.rank.service.impl.RankMessageTypeServiceImpl;
import org.junit.Test;

public class MemberMemberServiceTest {

    private RankMessageTypeService rankMessageTypeService = new RankMessageTypeServiceImpl();

    private RankService rankService = new RankServiceImpl();

    /**
     * 用例：创建修改，等级的佣金比例，价格
     */
    @Test
    public void test_add_new_rank(){
        RankEntity rankEntity = new RankEntity();
        rankEntity.setName("黄金会员");
        rankEntity.setRebatePercentLevel1(20);
        rankEntity.setRebatePercentLevel2(10);
        rankEntity.setRebatePercentLevel3(5);
        rankService.insert(rankEntity);
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
