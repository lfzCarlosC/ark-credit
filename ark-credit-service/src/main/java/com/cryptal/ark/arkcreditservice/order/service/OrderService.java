package com.cryptal.ark.arkcreditservice.order.service;

import com.cryptal.ark.arkcreditservice.order.request.CreateOrderRequest;

public interface OrderService {

    /**
     * 下单
     * @param request
     */
    void create(CreateOrderRequest request);
}
