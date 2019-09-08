package com.cryptal.ark.arkcreditservice.order.service.impl;

import com.cryptal.ark.arkcreditservice.order.dao.OrderDao;
import com.cryptal.ark.arkcreditservice.order.domain.Order;
import com.cryptal.ark.arkcreditservice.order.event.OrderCreated;
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

        checkCreditEnough(request);
        checkStockEnough(request);
        checkSkuCanBuy(request);

        Order order = constructOrder(request);
        orderDao.save(order);
        publisher.publishEvent(new OrderCreated(this,order.getId(),order.getUserId(),order.getUserId(),order.getCredit(),order.getSkuNum()));
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

    /**
     * 校验积分是否足够
     * @param request
     */
    private void checkCreditEnough(CreateOrderRequest request) {

    }

    private Order constructOrder(CreateOrderRequest request) {
        return new Order();
    }

}
