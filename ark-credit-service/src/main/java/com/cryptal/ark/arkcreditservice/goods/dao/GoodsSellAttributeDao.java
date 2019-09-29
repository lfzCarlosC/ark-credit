package com.cryptal.ark.arkcreditservice.goods.dao;

import cn.com.gome.cloud.openplatform.repository.GenericDao;
import com.cryptal.ark.arkcreditservice.goods.entity.GoodsSellAttributeEntity;

import java.util.List;

public interface GoodsSellAttributeDao extends GenericDao<GoodsSellAttributeEntity,Long> {

    List<GoodsSellAttributeEntity> findBySkuId(Long skuId);
}
