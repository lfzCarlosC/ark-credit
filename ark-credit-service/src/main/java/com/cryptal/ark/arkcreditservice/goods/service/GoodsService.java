package com.cryptal.ark.arkcreditservice.goods.service;

import com.cryptal.ark.arkcreditservice.order.event.OrderCreated;

public interface GoodsService {

    /**
     * 处理下单事件，库存数减少，执行商品Executor
     * @param event
     */
    void handleOrderCreated(OrderCreated event);
}
