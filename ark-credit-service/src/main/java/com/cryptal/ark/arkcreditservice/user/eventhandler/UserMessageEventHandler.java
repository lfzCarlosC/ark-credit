package com.cryptal.ark.arkcreditservice.user.eventhandler;

import com.cryptal.ark.arkcreditservice.user.event.UserAmountAdded;
import com.cryptal.ark.arkcreditservice.order.event.OrderCreated;
import com.cryptal.ark.arkcreditservice.user.event.UserRankExpired;
import com.cryptal.ark.arkcreditservice.user.service.UserMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class UserMessageEventHandler {

    @Autowired
    private UserMessageService userMessageService;

    @EventListener
    public void handle(UserAmountAdded event){

        userMessageService.receiveCreditAdded(event);

    }

    @EventListener
    public void handle(UserRankExpired event){
        userMessageService.receiveUserExpired(event);
    }

    @EventListener
    public void handle(OrderCreated event){
        userMessageService.receiveOrderCreated(event);
    }
}
