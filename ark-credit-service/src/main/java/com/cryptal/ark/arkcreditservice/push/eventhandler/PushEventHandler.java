package com.cryptal.ark.arkcreditservice.push.eventhandler;

import com.cryptal.ark.arkcreditservice.push.domain.PushRecord;
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
        PushRecord pushRecord = constructPushRecord(event);
        pushRecordService.insert(pushRecord);
    }

    @EventListener
    public void handle(PushMessageReceived event){
        pushMessageService.send(event.getPushMessage());
    }

    private PushRecord constructPushRecord(PushMessageSent event) {
        return new PushRecord();
    }

}
