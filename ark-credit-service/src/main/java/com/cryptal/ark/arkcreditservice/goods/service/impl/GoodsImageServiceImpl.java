package com.cryptal.ark.arkcreditservice.goods.service.impl;

import cn.com.gome.cloud.openplatform.repository.GenericDao;
import cn.com.gome.cloud.openplatform.service.impl.GenericServiceImpl;
import com.cryptal.ark.arkcreditservice.goods.dao.GoodsImageDao;
import com.cryptal.ark.arkcreditservice.goods.entity.GoodsImageEntity;
import com.cryptal.ark.arkcreditservice.goods.service.GoodsImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GoodsImageServiceImpl extends GenericServiceImpl<GoodsImageEntity,Long> implements GoodsImageService {

    @Autowired
    private GoodsImageDao goodsImageDao;

    @Override
    public List<GoodsImageEntity> findBySkuId(Long skuId) {
        return goodsImageDao.findBySkuId(skuId);
    }

    @Override
    public void insertAll(List<GoodsImageEntity> goodsImageList) {
        goodsImageDao.saveAll(goodsImageList);
    }

    @Override
    protected GenericDao<GoodsImageEntity, Long> getDao() {
        return goodsImageDao;
    }

}
