package com.cryptal.ark.arkcreditservice.goods.service.impl;

import cn.com.gome.cloud.openplatform.repository.GenericDao;
import cn.com.gome.cloud.openplatform.service.impl.GenericServiceImpl;
import com.cryptal.ark.arkcreditservice.goods.dao.GoodsSkuDao;
import com.cryptal.ark.arkcreditservice.goods.entity.GoodsSkuEntity;
import com.cryptal.ark.arkcreditservice.goods.request.GoodsSkuAddedRequest;
import com.cryptal.ark.arkcreditservice.goods.service.GoodsSkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GoodsSkuServiceImpl extends GenericServiceImpl<GoodsSkuEntity,Long> implements GoodsSkuService {

    @Autowired
    private GoodsSkuDao goodsSkuDao;

    @Override
    protected GenericDao<GoodsSkuEntity, Long> getDao() {
        return goodsSkuDao;
    }

    @Override
    public void addSku(GoodsSkuAddedRequest request) {

    }
}
