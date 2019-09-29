package com.cryptal.ark.arkcreditservice.goods.service;

import cn.com.gome.cloud.openplatform.service.GenericService;
import com.cryptal.ark.arkcreditservice.goods.entity.SellAttributeEntity;

import java.util.List;

public interface SellAttributeService extends GenericService<SellAttributeEntity,Long> {

    List<SellAttributeEntity> findByCategoryId(Long categoryId);

    SellAttributeEntity checkAndGet(Long id);

}
