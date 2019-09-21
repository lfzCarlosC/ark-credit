package com.cryptal.ark.arkcreditservice.goods.service.impl;

import com.cryptal.ark.arkcreditservice.goods.entity.GoodsSellAttributeEntity;
import com.cryptal.ark.arkcreditservice.goods.entity.SellAttributeValueEntity;
import com.cryptal.ark.arkcreditservice.goods.service.GoodsSellAttributeService;
import org.springframework.stereotype.Component;

@Component
public class GoodsSellAttributeServiceImpl implements GoodsSellAttributeService {


    @Override
    public SellAttributeValueEntity findBySkuAndSellAttributeId(Long skuId, Long sellAttributeId) {
        return null;
    }

    @Override
    public void save(GoodsSellAttributeEntity goodsSellAttributeEntity1) {

    }

    @Override
    public GoodsSellAttributeEntity findBySkuIdAndSellAttributeId(Long skuId, long attributeId) {
        return null;
    }
}
