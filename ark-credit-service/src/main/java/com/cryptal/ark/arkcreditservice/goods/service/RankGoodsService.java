package com.cryptal.ark.arkcreditservice.goods.service;

import com.cryptal.ark.arkcreditservice.goods.domain.RankGoods;

public interface RankGoodsService {

    RankGoods findByGoodsId(Long goodsId);

}
