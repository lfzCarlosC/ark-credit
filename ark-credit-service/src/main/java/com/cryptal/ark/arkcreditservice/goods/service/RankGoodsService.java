package com.cryptal.ark.arkcreditservice.goods.service;

import com.cryptal.ark.arkcreditservice.goods.entity.RankGoodsEntity;

public interface RankGoodsService {

    RankGoodsEntity findByGoodsId(Long goodsId);

}
