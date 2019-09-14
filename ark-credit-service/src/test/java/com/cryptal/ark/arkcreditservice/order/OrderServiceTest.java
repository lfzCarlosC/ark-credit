package com.cryptal.ark.arkcreditservice.order;

import com.cryptal.ark.arkcreditservice.order.request.CreateOrderRequest;
import com.cryptal.ark.arkcreditservice.order.service.OrderService;
import com.cryptal.ark.arkcreditservice.order.service.impl.OrderServiceImpl;

import java.math.BigDecimal;

public class OrderServiceTest {

    private OrderService orderService = new OrderServiceImpl();

    /**
     * 用例：用户下单
     */
    public void test_add_order(){

        CreateOrderRequest request = new CreateOrderRequest();
        request.setUserId(0L);
        request.setSkuId(0L);
        request.setPrice(new BigDecimal(100));
        orderService.create(request);

    }

}
