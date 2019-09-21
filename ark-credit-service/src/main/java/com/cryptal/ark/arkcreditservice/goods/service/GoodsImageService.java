package com.cryptal.ark.arkcreditservice.goods.service;

import com.cryptal.ark.arkcreditservice.goods.entity.GoodsImageEntity;

import java.util.List;

public interface GoodsImageService {

    List<GoodsImageEntity> findBySkuId(Long skuId);

    void save(GoodsImageEntity goodsImageEntity);

}
