package com.cryptal.ark.arkcreditservice.push.eventhandler;

import com.cryptal.ark.arkcreditservice.push.entity.PushRecordEntity;
import com.cryptal.ark.arkcreditservice.push.event.PushMessageReceived;
import com.cryptal.ark.arkcreditservice.push.event.PushMessageSent;
import com.cryptal.ark.arkcreditservice.push.service.PushMessageService;
import com.cryptal.ark.arkcreditservice.push.service.PushRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class PushEventHandler {

    @Autowired
    private PushRecordService pushRecordService;

    @Autowired
    private PushMessageService pushMessageService;

    /**
     * 记录发送记录
     * @param event
     */
    @EventListener
    public void handle(PushMessageSent event){
        PushRecordEntity pushRecordEntity = constructPushRecord(event);
        pushRecordService.insert(pushRecordEntity);
    }

    @EventListener
    public void handle(PushMessageReceived event){
        pushMessageService.send(event.getPushMessageEntity());
    }

    private PushRecordEntity constructPushRecord(PushMessageSent event) {
        return new PushRecordEntity();
    }

}
