package com.cryptal.ark.arkcreditservice.goods.service;

import com.cryptal.ark.arkcreditservice.goods.entity.ProductEntity;
import com.cryptal.ark.arkcreditservice.order.event.OrderCreated;

public interface GoodsService {

    /**
     * 处理下单事件，库存数减少，执行商品Executor
     * @param event
     */
    void handleOrderCreated(OrderCreated event);

    /**
     * 根据商品ID获取商品信息
     * @param id
     * @return
     */
    ProductEntity findById(Long id);

    void save(ProductEntity productEntity);
}
