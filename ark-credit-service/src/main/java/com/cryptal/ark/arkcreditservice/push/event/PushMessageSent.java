package com.cryptal.ark.arkcreditservice.push.event;

import com.cryptal.ark.arkcreditservice.push.domain.PushMessage;
import com.cryptal.ark.arkcreditservice.push.domain.SendResult;
import com.cryptal.ark.arkcreditservice.rank.domain.RankMessageType;
import com.cryptal.ark.arkcreditservice.user.domain.Device;
import org.springframework.context.ApplicationEvent;

import java.util.Date;

/**
 * PUSH消息被创建
 */
public class PushMessageSent extends ApplicationEvent {

    /**
     * 发送目标用户
     */
    private Long userId;

    /**
     * 级别ID
     */
    private Long rankId;

    /**
     * 发送消息正文
     */
    private String content;


    /**
     * 消息类型
     */
    private Long messageTypeId;

    /**
     * 发送时间
     */
    private Date pushTime;

    /**
     * 设备ID
     */
    private Long deviceId;

    public PushMessageSent(Object source, PushMessage pushMessage, Device device, RankMessageType rankMessageType, SendResult sendResult) {
        super(source);
        this.content = pushMessage.getContent();
        this.pushTime = pushMessage.getPushTime();
        this.messageTypeId = pushMessage.getMessageTypeId();
        this.deviceId = device.getId();
        this.userId = device.getUserId();
        this.rankId = rankMessageType.getRankId();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRankId() {
        return rankId;
    }

    public void setRankId(Long rankId) {
        this.rankId = rankId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getMessageTypeId() {
        return messageTypeId;
    }

    public void setMessageTypeId(Long messageTypeId) {
        this.messageTypeId = messageTypeId;
    }

    public Date getPushTime() {
        return pushTime;
    }

    public void setPushTime(Date pushTime) {
        this.pushTime = pushTime;
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }
}
