package com.cryptal.ark.arkcreditservice.goods.dao;

import com.cryptal.ark.arkcreditservice.goods.entity.GoodsSellAttributeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsSellAttributeDao extends JpaRepository<GoodsSellAttributeEntity,Long> {
    GoodsSellAttributeEntity findBySkuIdAndSellAttributeId(Long skuId, long sellAttributeId);
}
