package com.cryptal.ark.arkcreditservice.goods.service;

import cn.com.gome.cloud.openplatform.service.GenericService;
import com.cryptal.ark.arkcreditservice.goods.entity.ProductEntity;
import com.cryptal.ark.arkcreditservice.order.event.OrderCreated;

public interface ProductService extends GenericService<ProductEntity,Long> {

    /**
     * 处理下单事件，库存数减少，执行商品Executor
     * @param event
     */
    void handleOrderCreated(OrderCreated event);

    ProductEntity checkAndGet(Long productId);
}
