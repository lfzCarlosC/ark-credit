package com.cryptal.ark.arkcreditservice.goods.service.impl;

import com.cryptal.ark.arkcreditservice.goods.domain.SellAttribute;
import com.cryptal.ark.arkcreditservice.goods.service.SellAttributeService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SellAttributeServiceImpl implements SellAttributeService {
    @Override
    public List<SellAttribute> findByCategoryId(Long categoryId) {
        return null;
    }

    @Override
    public void save(SellAttribute sellAttribute) {

    }
}
