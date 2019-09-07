package com.cryptal.ark.arkcreditservice.timer;

import com.cryptal.ark.arkcreditservice.user.domain.UserRank;
import com.cryptal.ark.arkcreditservice.user.event.UserExpired;
import com.cryptal.ark.arkcreditservice.user.service.UserRankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ExpireUserTimer {

    @Autowired
    private UserRankService userRankService;

    @Autowired
    private ApplicationEventPublisher publisher;

    /**
     * 每天排除到期的用户
     */
    public void expireUser(){

        List<UserRank> userRankList = userRankService.findExpired();

        for (UserRank userRank : userRankList) {
            publisher.publishEvent(new UserExpired(this,userRank.getUserId()));
        }

    }

}
