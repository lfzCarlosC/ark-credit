package com.cryptal.ark.arkcreditservice.push.event;

import com.cryptal.ark.arkcreditservice.push.domain.PushMessage;
import org.springframework.context.ApplicationEvent;

public class PushMessageReceived extends ApplicationEvent {

    private PushMessage pushMessage;

    public PushMessageReceived(Object source,PushMessage pushMessage) {
        super(source);
        this.pushMessage = pushMessage;
    }

    public PushMessage getPushMessage() {
        return pushMessage;
    }

    public void setPushMessage(PushMessage pushMessage) {
        this.pushMessage = pushMessage;
    }

}
