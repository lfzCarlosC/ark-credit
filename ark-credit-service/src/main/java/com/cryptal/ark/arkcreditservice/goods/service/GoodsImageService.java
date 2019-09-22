package com.cryptal.ark.arkcreditservice.goods.service;

import cn.com.gome.cloud.openplatform.service.GenericService;
import com.cryptal.ark.arkcreditservice.goods.entity.GoodsImageEntity;

import java.util.List;

public interface GoodsImageService extends GenericService<GoodsImageEntity,Long> {

    List<GoodsImageEntity> findBySkuId(Long skuId);

}
