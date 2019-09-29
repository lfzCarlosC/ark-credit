package com.cryptal.ark.arkcreditservice.goods.service.impl;

import cn.com.gome.cloud.openplatform.repository.GenericDao;
import cn.com.gome.cloud.openplatform.service.impl.GenericServiceImpl;
import com.cryptal.ark.arkcreditservice.goods.dao.GoodsSellAttributeDao;
import com.cryptal.ark.arkcreditservice.goods.entity.GoodsSellAttributeEntity;
import com.cryptal.ark.arkcreditservice.goods.entity.SellAttributeValueEntity;
import com.cryptal.ark.arkcreditservice.goods.service.GoodsSellAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GoodsSellAttributeServiceImpl extends GenericServiceImpl<GoodsSellAttributeEntity,Long> implements GoodsSellAttributeService {

    @Autowired
    private GoodsSellAttributeDao goodsSellAttributeDao;

    @Override
    public SellAttributeValueEntity findBySkuAndSellAttributeId(Long skuId, Long sellAttributeId) {
        return null;
    }

    @Override
    public GoodsSellAttributeEntity findBySkuIdAndSellAttributeId(Long skuId, long attributeId) {
        return null;
    }

    @Override
    public void saveAll(List<GoodsSellAttributeEntity> goodsSellAttributeEntities) {
        goodsSellAttributeDao.saveAll(goodsSellAttributeEntities);
    }

    @Override
    protected GenericDao<GoodsSellAttributeEntity, Long> getDao() {
        return goodsSellAttributeDao;
    }

}
