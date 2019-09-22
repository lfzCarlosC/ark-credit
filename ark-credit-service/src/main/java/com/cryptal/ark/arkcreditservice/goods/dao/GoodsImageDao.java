package com.cryptal.ark.arkcreditservice.goods.dao;

import cn.com.gome.cloud.openplatform.repository.GenericDao;
import com.cryptal.ark.arkcreditservice.goods.entity.GoodsImageEntity;

import java.util.List;

public interface GoodsImageDao extends GenericDao<GoodsImageEntity,Long> {


    List<GoodsImageEntity> findBySkuId(Long skuId);

}
