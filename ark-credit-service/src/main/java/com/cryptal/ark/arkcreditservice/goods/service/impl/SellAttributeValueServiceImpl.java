package com.cryptal.ark.arkcreditservice.goods.service.impl;

import cn.com.gome.cloud.openplatform.repository.GenericDao;
import cn.com.gome.cloud.openplatform.service.impl.GenericServiceImpl;
import com.cryptal.ark.arkcreditservice.goods.dao.SellAttributeValueDao;
import com.cryptal.ark.arkcreditservice.goods.entity.SellAttributeValueEntity;
import com.cryptal.ark.arkcreditservice.goods.service.SellAttributeValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SellAttributeValueServiceImpl extends GenericServiceImpl<SellAttributeValueEntity,Long> implements SellAttributeValueService{

    @Autowired
    private SellAttributeValueDao sellAttributeValueDao;

    @Override
    public List<SellAttributeValueEntity> findByAttributeId(Long attributeId) {
        return sellAttributeValueDao.findByAttributeIdOrderBySortNumAsc(attributeId);
    }

    @Override
    protected GenericDao<SellAttributeValueEntity, Long> getDao() {
        return sellAttributeValueDao;
    }
}
