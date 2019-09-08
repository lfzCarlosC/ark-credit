package com.cryptal.ark.arkcreditservice.user.service.impl;

import com.cryptal.ark.arkcreditservice.credit.event.UserCreditAdded;
import com.cryptal.ark.arkcreditservice.user.dao.UserMessageDao;
import com.cryptal.ark.arkcreditservice.user.domain.UserMessage;
import com.cryptal.ark.arkcreditservice.member.event.MemberExpired;
import com.cryptal.ark.arkcreditservice.user.service.UserMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMessageServiceImpl implements UserMessageService {

    @Autowired
    private UserMessageDao userMessageDao;

    @Override
    public void receiveCreditAdded(UserCreditAdded event) {
        UserMessage userMessage = constructCreditAddedMessage();
        userMessageDao.save(userMessage);
    }

    @Override
    public void receiveUserExpired(MemberExpired event) {

    }

    private UserMessage constructCreditAddedMessage() {
        return new UserMessage();
    }

}
