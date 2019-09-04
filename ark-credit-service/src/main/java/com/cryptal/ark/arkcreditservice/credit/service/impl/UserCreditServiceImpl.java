package com.cryptal.ark.arkcreditservice.credit.service.impl;

import com.cryptal.ark.arkcreditservice.config.service.ConfigService;
import com.cryptal.ark.arkcreditservice.credit.dao.UserCreditRepository;
import com.cryptal.ark.arkcreditservice.credit.domain.UserCredit;
import com.cryptal.ark.arkcreditservice.credit.event.UserCreditAdded;
import com.cryptal.ark.arkcreditservice.credit.service.UserCreditService;
import com.cryptal.ark.arkcreditservice.user.event.UserRegistered;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class UserCreditServiceImpl implements UserCreditService {

    @Autowired
    private UserCreditRepository userCreditRepository;

    @Autowired
    private ApplicationEventPublisher publisher;

    @Autowired
    private ConfigService configService;

    @Override
    public void handleRegisterEvent(UserRegistered event) {

        UserCredit userCredit = constructNew(event);
        userCreditRepository.save(userCredit);

        UserCredit invitedUserCredit =  userCreditRepository.findByUserId(event.getInvitedUserId());
        if(invitedUserCredit!=null){
            invitedUserCredit.setCredit(invitedUserCredit.getCredit() + configService.getInviteUserReward());
            userCreditRepository.saveAndFlush(invitedUserCredit);
        }

        publisher.publishEvent(new UserCreditAdded(this,event.getUserId(),configService.getNewUserReward(),"新注册用户奖励"));
        publisher.publishEvent(new UserCreditAdded(this,event.getInvitedUserId(),configService.getInviteUserReward(),"邀请用户奖励"));

    }

    private UserCredit constructNew(UserRegistered event) {
        return null;
    }
}
