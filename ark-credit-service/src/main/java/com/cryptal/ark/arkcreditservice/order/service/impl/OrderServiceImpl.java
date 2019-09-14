package com.cryptal.ark.arkcreditservice.order.service.impl;

import com.cryptal.ark.arkcreditservice.order.dao.OrderDao;
import com.cryptal.ark.arkcreditservice.order.domain.Order;
import com.cryptal.ark.arkcreditservice.order.request.CreateOrderRequest;
import com.cryptal.ark.arkcreditservice.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private ApplicationEventPublisher publisher;

    @Override
    public void create(CreateOrderRequest request) {

        checkStockEnough(request);
        checkSkuCanBuy(request);

    }

    /**
     * 校验商品是否可以购买
     * @param request
     */
    private void checkSkuCanBuy(CreateOrderRequest request) {

    }

    /**
     * 校验库存是否足够
     * @param request
     */
    private void checkStockEnough(CreateOrderRequest request) {

    }

    private Order constructOrder(CreateOrderRequest request) {
        return new Order();
    }

}
