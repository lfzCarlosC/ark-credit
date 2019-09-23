package com.cryptal.ark.arkcreditservice.push.service;

import com.cryptal.ark.arkcreditservice.push.entity.PushMessageEntity;

public interface PushMessageService {

    /**
     * 接收要推送的消息
     * @param content           正文
     * @param messageTypeId     消息类型ID
     */
    void receiveMsg(Long messageTypeId,String content);

    /**
     * 发送消息给用户设备
     */
    void send(PushMessageEntity pushMessageEntity);
}
