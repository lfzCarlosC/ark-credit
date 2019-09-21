package com.cryptal.ark.arkcreditservice.goods;

import com.cryptal.ark.arkcreditservice.goods.entity.SellAttributeValueEntity;

import java.util.List;

public interface SellAttributeValueService {

    List<SellAttributeValueEntity> findByAttributeId(Long attributeId);


    void save(SellAttributeValueEntity sellAttributeValueEntity);

    SellAttributeValueEntity findById(Long sellAttributeValueId);

}
