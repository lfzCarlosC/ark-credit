package com.cryptal.ark.arkcreditservice.goods.dao;

import cn.com.gome.cloud.openplatform.repository.GenericDao;
import com.cryptal.ark.arkcreditservice.goods.entity.GoodsSellAttributeEntity;

public interface GoodsSellAttributeDao extends GenericDao<GoodsSellAttributeEntity,Long> {
    GoodsSellAttributeEntity findBySkuIdAndSellAttributeId(Long skuId, long sellAttributeId);
}
