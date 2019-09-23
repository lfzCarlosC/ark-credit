package com.cryptal.ark.arkcreditservice.push.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
public class PushRecordEntity implements Serializable {

    @Id
    private Long id;

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
    private Date sendTime;

    /**
     * 设备ID
     */
    private Long deviceId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }
}
