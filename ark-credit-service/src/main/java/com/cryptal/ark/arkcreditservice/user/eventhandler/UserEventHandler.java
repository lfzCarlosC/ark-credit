package com.cryptal.ark.arkcreditservice.user.eventhandler;

import com.cryptal.ark.arkcreditservice.user.event.UserExpired;
import com.cryptal.ark.arkcreditservice.user.service.UserRankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class UserEventHandler {

    @Autowired
    private UserRankService userRankService;

    @EventListener
    public void handle(UserExpired userExpired){

        userRankService.removeExpireUser(userExpired.getUserId());

    }

}
