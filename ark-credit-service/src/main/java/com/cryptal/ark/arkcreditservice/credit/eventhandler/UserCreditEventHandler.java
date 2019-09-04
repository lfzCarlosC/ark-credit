package com.cryptal.ark.arkcreditservice.credit.eventhandler;

import com.cryptal.ark.arkcreditservice.credit.service.UserCreditService;
import com.cryptal.ark.arkcreditservice.user.event.UserRegistered;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class UserCreditEventHandler {

    @Autowired
    private UserCreditService userCreditService;

    @EventListener
    public void handle(UserRegistered event){

        userCreditService.handleRegisterEvent(event);

    }

}
