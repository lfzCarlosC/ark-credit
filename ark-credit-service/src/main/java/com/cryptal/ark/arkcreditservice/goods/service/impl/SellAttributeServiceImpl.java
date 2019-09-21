package com.cryptal.ark.arkcreditservice.goods.service.impl;

import cn.com.gome.cloud.openplatform.repository.GenericDao;
import cn.com.gome.cloud.openplatform.service.impl.GenericServiceImpl;
import com.cryptal.ark.arkcreditservice.goods.dao.SellAttributeDao;
import com.cryptal.ark.arkcreditservice.goods.entity.SellAttributeEntity;
import com.cryptal.ark.arkcreditservice.goods.service.SellAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SellAttributeServiceImpl extends GenericServiceImpl<SellAttributeEntity,Long> implements SellAttributeService {

    @Autowired
    private SellAttributeDao sellAttributeDao;

    @Override
    public List<SellAttributeEntity> findByCategoryId(Long categoryId) {
        return sellAttributeDao.findByCategoryId(categoryId);
    }

    @Override
    protected GenericDao<SellAttributeEntity, Long> getDao() {
        return sellAttributeDao;
    }
}
