package com.cryptal.ark.arkcreditservice.goods.service.impl;

import com.cryptal.ark.arkcreditservice.goods.domain.GoodsImage;
import com.cryptal.ark.arkcreditservice.goods.service.GoodsImageService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GoodsImageServiceImpl implements GoodsImageService {


    @Override
    public List<GoodsImage> findBySkuId(Long skuId) {
        return null;
    }

    @Override
    public void save(GoodsImage goodsImage) {

    }
}
