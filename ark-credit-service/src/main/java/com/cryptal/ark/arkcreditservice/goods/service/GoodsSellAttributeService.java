package com.cryptal.ark.arkcreditservice.goods.service;

import com.cryptal.ark.arkcreditservice.goods.entity.GoodsSellAttributeEntity;
import com.cryptal.ark.arkcreditservice.goods.entity.SellAttributeValueEntity;

public interface GoodsSellAttributeService {

    /**
     *
     * @param skuId             SKU
     * @param sellAttributeId   销售属性ID
     * @return
     */
    SellAttributeValueEntity findBySkuAndSellAttributeId(Long skuId, Long sellAttributeId);

    void save(GoodsSellAttributeEntity goodsSellAttributeEntity1);

    GoodsSellAttributeEntity findBySkuIdAndSellAttributeId(Long skuId, long attributeId);
}
