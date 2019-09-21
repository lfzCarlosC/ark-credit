package com.cryptal.ark.arkcreditservice.goods.service;

import com.cryptal.ark.arkcreditservice.goods.SellAttributeValueService;
import com.cryptal.ark.arkcreditservice.goods.entity.SellAttributeValueEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SellAttributeValueServiceImpl implements SellAttributeValueService{
    @Override
    public List<SellAttributeValueEntity> findByAttributeId(Long attributeId) {
        return null;
    }

    @Override
    public void save(SellAttributeValueEntity sellAttributeValueEntity) {

    }

    @Override
    public SellAttributeValueEntity findById(Long sellAttributeValueId) {
        return null;
    }
}
