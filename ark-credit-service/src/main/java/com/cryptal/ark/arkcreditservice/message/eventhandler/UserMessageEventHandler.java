package com.cryptal.ark.arkcreditservice.message.eventhandler;

import com.cryptal.ark.arkcreditservice.credit.event.UserCreditAdded;
import com.cryptal.ark.arkcreditservice.message.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class UserMessageEventHandler {

    @Autowired
    private MessageService messageService;

    @EventListener
    public void handle(UserCreditAdded event){

        messageService.receiveCreditAdded(event);

    }

}
