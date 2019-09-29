package com.cryptal.ark.arkcreditservice.goods.service;

import cn.com.gome.cloud.openplatform.service.GenericService;
import com.cryptal.ark.arkcreditservice.goods.entity.SellAttributeValueEntity;

import java.util.List;

public interface SellAttributeValueService extends GenericService<SellAttributeValueEntity,Long> {

    List<SellAttributeValueEntity> findByAttributeId(Long attributeId);

    SellAttributeValueEntity checkAndGet(Long valueId);

}
