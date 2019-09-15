package com.cryptal.ark.arkcreditservice.goods.dao;

import com.cryptal.ark.arkcreditservice.goods.domain.GoodsSellAttribute;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsSellAttributeDao extends JpaRepository<GoodsSellAttribute,Long> {
    GoodsSellAttribute findBySkuIdAndSellAttributeId(Long skuId, long sellAttributeId);
}
