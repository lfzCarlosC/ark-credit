package com.cryptal.ark.arkcreditservice.goods.facade;

import com.cryptal.ark.interfaze.goods.request.GoodsSkuAddedRequest;

public interface GoodsFacade {
    /**
     * 添加SKU
     * @param goodsSkuAddedRequest
     */
    void addSku(GoodsSkuAddedRequest goodsSkuAddedRequest);
}
