package com.cryptal.ark.arkcreditservice.goods.eventhandler;

import com.cryptal.ark.arkcreditservice.goods.service.ProductService;
import com.cryptal.ark.arkcreditservice.order.event.OrderCreated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class GoodsEventHandler {

    @Autowired
    private ProductService productService;

    @EventListener
    public void handle(OrderCreated event){

        productService.handleOrderCreated(event);

    }

}
