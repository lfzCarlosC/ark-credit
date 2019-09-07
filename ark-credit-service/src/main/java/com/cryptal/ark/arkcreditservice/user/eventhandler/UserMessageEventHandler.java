package com.cryptal.ark.arkcreditservice.user.eventhandler;

import com.cryptal.ark.arkcreditservice.credit.event.UserCreditAdded;
import com.cryptal.ark.arkcreditservice.user.event.UserExpired;
import com.cryptal.ark.arkcreditservice.user.service.UserMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class UserMessageEventHandler {

    @Autowired
    private UserMessageService userMessageService;

    @EventListener
    public void handle(UserCreditAdded event){

        userMessageService.receiveCreditAdded(event);

    }

    @EventListener
    public void handle(UserExpired event){

        userMessageService.receiveUserExpired(event);

    }

}
