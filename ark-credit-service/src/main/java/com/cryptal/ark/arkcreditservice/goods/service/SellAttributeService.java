package com.cryptal.ark.arkcreditservice.goods.service;

import com.cryptal.ark.arkcreditservice.goods.domain.SellAttribute;

import java.util.List;

public interface SellAttributeService {

    List<SellAttribute> findByCategoryId(Long categoryId);

    void save(SellAttribute sellAttribute);
}
