package com.cryptal.ark.arkcreditservice.goods.service.impl;

import cn.com.gome.cloud.openplatform.repository.GenericDao;
import cn.com.gome.cloud.openplatform.service.impl.GenericServiceImpl;
import com.cryptal.ark.arkcreditservice.common.exp.CreditException;
import com.cryptal.ark.arkcreditservice.goods.dao.SellAttributeValueDao;
import com.cryptal.ark.arkcreditservice.goods.entity.SellAttributeValueEntity;
import com.cryptal.ark.arkcreditservice.goods.service.SellAttributeValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class SellAttributeValueServiceImpl extends GenericServiceImpl<SellAttributeValueEntity,Long> implements SellAttributeValueService{

    @Autowired
    private SellAttributeValueDao sellAttributeValueDao;

    @Override
    public List<SellAttributeValueEntity> findByAttributeId(Long attributeId) {
        return sellAttributeValueDao.findByAttributeIdOrderBySortNumAsc(attributeId);
    }

    @Override
    public SellAttributeValueEntity checkAndGet(Long valueId) {
        Optional<SellAttributeValueEntity> sellAttributeValueOption = sellAttributeValueDao.findById(valueId);
        if(sellAttributeValueOption.isPresent()){
            return sellAttributeValueOption.get();
        }
        throw new CreditException("销售属性值不存在" + valueId);
    }

    @Override
    protected GenericDao<SellAttributeValueEntity, Long> getDao() {
        return sellAttributeValueDao;
    }
}
