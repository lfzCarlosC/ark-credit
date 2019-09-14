package com.cryptal.ark.arkcreditservice.goods;

import com.cryptal.ark.arkcreditservice.goods.domain.SellAttributeValue;

import java.util.List;

public interface SellAttributeValueService {

    List<SellAttributeValue> findByAttributeId(Long attributeId);


    void save(SellAttributeValue sellAttributeValue);

}
