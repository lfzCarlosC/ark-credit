package com.cryptal.ark.arkcreditservice.goods.service.impl;

import cn.com.gome.cloud.openplatform.repository.GenericDao;
import cn.com.gome.cloud.openplatform.service.impl.GenericServiceImpl;
import com.cryptal.ark.arkcreditservice.common.exp.CreditException;
import com.cryptal.ark.arkcreditservice.goods.dao.SellAttributeDao;
import com.cryptal.ark.arkcreditservice.goods.entity.SellAttributeEntity;
import com.cryptal.ark.arkcreditservice.goods.service.SellAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class SellAttributeServiceImpl extends GenericServiceImpl<SellAttributeEntity,Long> implements SellAttributeService {

    @Autowired
    private SellAttributeDao sellAttributeDao;

    @Override
    public List<SellAttributeEntity> findByCategoryId(Long categoryId) {
        return sellAttributeDao.findByCategoryIdOrderBySortNumAsc(categoryId);
    }

    @Override
    public SellAttributeEntity checkAndGet(Long id) {
        Optional<SellAttributeEntity> sellAttributeOption = sellAttributeDao.findById(id);
        if(sellAttributeOption.isPresent()){
            return sellAttributeOption.get();
        }
        throw new CreditException("销售属性ID不存在" + id);
    }

    @Override
    protected GenericDao<SellAttributeEntity, Long> getDao() {
        return sellAttributeDao;
    }
}
