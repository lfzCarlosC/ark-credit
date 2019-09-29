package com.cryptal.ark.arkcreditservice.goods.service;

import cn.com.gome.cloud.openplatform.service.GenericService;
import com.cryptal.ark.arkcreditservice.goods.entity.GoodsSellAttributeEntity;
import com.cryptal.ark.arkcreditservice.goods.entity.SellAttributeValueEntity;

import java.util.List;

public interface GoodsSellAttributeService extends GenericService<GoodsSellAttributeEntity,Long> {

    SellAttributeValueEntity findBySkuAndSellAttributeId(Long skuId, Long sellAttributeId);

    GoodsSellAttributeEntity findBySkuIdAndSellAttributeId(Long skuId, long attributeId);

    void saveAll(List<GoodsSellAttributeEntity> goodsSellAttributeEntities);
}
