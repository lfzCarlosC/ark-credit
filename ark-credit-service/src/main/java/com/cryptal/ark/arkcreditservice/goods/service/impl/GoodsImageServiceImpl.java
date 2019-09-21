package com.cryptal.ark.arkcreditservice.goods.service.impl;

import com.cryptal.ark.arkcreditservice.goods.entity.GoodsImageEntity;
import com.cryptal.ark.arkcreditservice.goods.service.GoodsImageService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GoodsImageServiceImpl implements GoodsImageService {


    @Override
    public List<GoodsImageEntity> findBySkuId(Long skuId) {
        return null;
    }

    @Override
    public void save(GoodsImageEntity goodsImageEntity) {

    }
}
