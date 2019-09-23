package com.cryptal.ark.arkcreditservice.push.event;

import com.cryptal.ark.arkcreditservice.push.entity.PushMessageEntity;
import org.springframework.context.ApplicationEvent;

public class PushMessageReceived extends ApplicationEvent {

    private PushMessageEntity pushMessageEntity;

    public PushMessageReceived(Object source, PushMessageEntity pushMessageEntity) {
        super(source);
        this.pushMessageEntity = pushMessageEntity;
    }

    public PushMessageEntity getPushMessageEntity() {
        return pushMessageEntity;
    }

    public void setPushMessageEntity(PushMessageEntity pushMessageEntity) {
        this.pushMessageEntity = pushMessageEntity;
    }

}
