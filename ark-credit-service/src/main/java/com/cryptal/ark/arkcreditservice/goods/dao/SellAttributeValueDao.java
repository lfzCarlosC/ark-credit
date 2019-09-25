package com.cryptal.ark.arkcreditservice.goods.dao;

import cn.com.gome.cloud.openplatform.repository.GenericDao;
import com.cryptal.ark.arkcreditservice.goods.entity.SellAttributeValueEntity;

import java.util.List;

public interface SellAttributeValueDao extends GenericDao<SellAttributeValueEntity,Long> {
    List<SellAttributeValueEntity> findByAttributeIdOrderBySortNumAsc(Long attributeId);
}
