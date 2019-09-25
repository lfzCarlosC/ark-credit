package com.cryptal.ark.arkcreditservice.goods.dao;

import cn.com.gome.cloud.openplatform.repository.GenericDao;
import com.cryptal.ark.arkcreditservice.goods.entity.SellAttributeEntity;

import java.util.List;

public interface SellAttributeDao extends GenericDao<SellAttributeEntity,Long> {

    List<SellAttributeEntity> findByCategoryIdOrderBySortNumAsc(Long categoryId);

}
