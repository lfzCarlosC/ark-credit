package com.cryptal.ark.arkcreditservice.goods.service;

import cn.com.gome.cloud.openplatform.service.GenericService;
import com.cryptal.ark.arkcreditservice.goods.entity.GoodsSkuEntity;
import com.cryptal.ark.interfaze.goods.request.GoodsSkuAddedRequest;

public interface GoodsSkuService extends GenericService<GoodsSkuEntity,Long> {

    GoodsSkuEntity checkAndGet(Long id);

    void enable(Long id);

    void disable(Long id);
}
