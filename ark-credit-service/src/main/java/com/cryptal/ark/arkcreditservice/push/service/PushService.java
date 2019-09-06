package com.cryptal.ark.arkcreditservice.push.service;

import com.cryptal.ark.arkcreditservice.push.domain.Push;

public interface PushService {
    /**
     * 推送PUSH类型
     * @param push
     */
    void send(Push push);
}
