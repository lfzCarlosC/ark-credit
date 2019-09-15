package com.cryptal.ark.arkcreditservice.goods.service;

import com.cryptal.ark.arkcreditservice.goods.SellAttributeValueService;
import com.cryptal.ark.arkcreditservice.goods.domain.SellAttributeValue;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SellAttributeValueServiceImpl implements SellAttributeValueService{
    @Override
    public List<SellAttributeValue> findByAttributeId(Long attributeId) {
        return null;
    }

    @Override
    public void save(SellAttributeValue sellAttributeValue) {

    }

    @Override
    public SellAttributeValue findById(Long sellAttributeValueId) {
        return null;
    }
}
