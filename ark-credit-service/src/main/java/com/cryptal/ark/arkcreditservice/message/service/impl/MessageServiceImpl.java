package com.cryptal.ark.arkcreditservice.message.service.impl;

import com.cryptal.ark.arkcreditservice.credit.event.UserCreditAdded;
import com.cryptal.ark.arkcreditservice.message.dao.MessageRepository;
import com.cryptal.ark.arkcreditservice.message.domain.Message;
import com.cryptal.ark.arkcreditservice.message.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public void receiveCreditAdded(UserCreditAdded event) {
        Message message = constructCreditAddedMessage();
        messageRepository.save(message);
    }

    private Message constructCreditAddedMessage() {
        return new Message();
    }

}
