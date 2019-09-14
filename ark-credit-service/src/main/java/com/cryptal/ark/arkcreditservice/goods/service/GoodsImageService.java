package com.cryptal.ark.arkcreditservice.goods.service;

import com.cryptal.ark.arkcreditservice.goods.domain.GoodsImage;

import java.util.List;

public interface GoodsImageService {

    List<GoodsImage> findBySkuId(Long skuId);

    void save(GoodsImage goodsImage);

}
