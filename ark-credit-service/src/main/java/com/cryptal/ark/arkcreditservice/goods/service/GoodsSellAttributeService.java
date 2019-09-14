package com.cryptal.ark.arkcreditservice.goods.service;

import com.cryptal.ark.arkcreditservice.goods.domain.GoodsSellAttribute;
import com.cryptal.ark.arkcreditservice.goods.domain.SellAttributeValue;

public interface GoodsSellAttributeService {

    /**
     *
     * @param skuId             SKU
     * @param sellAttributeId   销售属性ID
     * @return
     */
    SellAttributeValue findBySkuAndSellAttributeId(Long skuId, Long sellAttributeId);

    void save(GoodsSellAttribute goodsSellAttribute1);
}
