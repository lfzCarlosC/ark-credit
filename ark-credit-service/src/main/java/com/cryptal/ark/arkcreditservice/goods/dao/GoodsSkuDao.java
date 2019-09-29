package com.cryptal.ark.arkcreditservice.goods.dao;

import cn.com.gome.cloud.openplatform.repository.GenericDao;
import com.cryptal.ark.arkcreditservice.goods.entity.GoodsSkuEntity;

import java.util.List;

public interface GoodsSkuDao extends GenericDao<GoodsSkuEntity,Long> {

    List<GoodsSkuEntity> findByProductId(Long id);

}
