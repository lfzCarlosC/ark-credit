package com.cryptal.ark.arkcreditservice.goods.service.impl;

import com.cryptal.ark.arkcreditservice.goods.domain.GoodsSellAttribute;
import com.cryptal.ark.arkcreditservice.goods.domain.SellAttributeValue;
import com.cryptal.ark.arkcreditservice.goods.service.GoodsSellAttributeService;
import org.springframework.stereotype.Component;

@Component
public class GoodsSellAttributeServiceImpl implements GoodsSellAttributeService {


    @Override
    public SellAttributeValue findBySkuAndSellAttributeId(Long skuId, Long sellAttributeId) {
        return null;
    }

    @Override
    public void save(GoodsSellAttribute goodsSellAttribute1) {

    }
}
