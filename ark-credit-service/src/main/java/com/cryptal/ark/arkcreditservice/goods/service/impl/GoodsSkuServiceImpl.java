package com.cryptal.ark.arkcreditservice.goods.service.impl;
import java.util.Date;
import java.util.Map;

import cn.com.gome.cloud.openplatform.repository.GenericDao;
import cn.com.gome.cloud.openplatform.service.impl.GenericServiceImpl;
import com.cryptal.ark.arkcreditservice.goods.dao.GoodsSkuDao;
import com.cryptal.ark.arkcreditservice.goods.entity.GoodsSkuEntity;
import com.cryptal.ark.arkcreditservice.goods.service.GoodsSkuService;
import com.cryptal.ark.interfaze.goods.domain.GoodsSku;
import com.cryptal.ark.interfaze.goods.request.GoodsSkuAddedRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GoodsSkuServiceImpl extends GenericServiceImpl<GoodsSkuEntity,Long> implements GoodsSkuService {

    @Autowired
    private GoodsSkuDao goodsSkuDao;

    private Gson gson = new GsonBuilder().create();

    @Override
    protected GenericDao<GoodsSkuEntity, Long> getDao() {
        return goodsSkuDao;
    }

    @Override
    public void createSku(GoodsSkuAddedRequest goodsSkuAddedRequest) {


    }

}
