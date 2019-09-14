package com.cryptal.ark.arkcreditservice.goods.service.impl;

import com.cryptal.ark.arkcreditservice.goods.domain.RankGoods;
import com.cryptal.ark.arkcreditservice.goods.service.GoodsExecutor;
import com.cryptal.ark.arkcreditservice.goods.service.RankGoodsService;
import com.cryptal.ark.arkcreditservice.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RankGoodsExecutor implements GoodsExecutor {

    @Autowired
    private RankGoodsService rankGoodsService;

    @Autowired
    private MemberService memberService;

    /**
     * 找到商品对应的等级，将用户设置为该等级
     * @param goodsId
     * @param userId
     */
    @Override
    public void execute(Long goodsId, Long userId) {

        RankGoods rankGoods = rankGoodsService.findByGoodsId(goodsId);
        memberService.assignUserWithRank(userId,rankGoods.getRankId(),rankGoods.getDays());

    }


}
