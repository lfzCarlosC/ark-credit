package com.cryptal.ark.arkcreditservice.goods.service.impl;

import com.cryptal.ark.arkcreditservice.goods.domain.GoodsType;
import com.cryptal.ark.arkcreditservice.goods.service.GoodsExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GoodsExecutors {

    @Autowired
    private CommonGoodsExecutor commonGoodsExecutor;

    @Autowired
    private RankGoodsExecutor rankGoodsExecutor;

    public GoodsExecutor findCurrent(GoodsType goodsType) {
        switch (goodsType){
            case RANK:
                return rankGoodsExecutor;
            default:
                return commonGoodsExecutor;
        }
    }


}
