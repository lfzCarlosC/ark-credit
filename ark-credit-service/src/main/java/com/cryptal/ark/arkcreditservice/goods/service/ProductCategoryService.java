package com.cryptal.ark.arkcreditservice.goods.service;

import cn.com.gome.cloud.openplatform.service.GenericService;
import com.cryptal.ark.arkcreditservice.goods.entity.ProductCategoryEntity;

import java.util.List;

public interface ProductCategoryService extends GenericService<ProductCategoryEntity,Long> {
    List<ProductCategoryEntity> findAllEnable();
}
