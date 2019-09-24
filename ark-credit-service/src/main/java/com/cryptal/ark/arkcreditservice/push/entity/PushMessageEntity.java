package com.cryptal.ark.arkcreditservice.push.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class PushMessageEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    /**
     * 消息正文
     */
    private String content;

    /**
     * 推送时间
     */
    private Date pushTime;

    /**
     * PUSH分类ID
     */
    private long messageTypeId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPushTime() {
        return pushTime;
    }

    public void setPushTime(Date pushTime) {
        this.pushTime = pushTime;
    }

    public long getMessageTypeId() {
        return messageTypeId;
    }

    public void setMessageTypeId(long messageTypeId) {
        this.messageTypeId = messageTypeId;
    }
}
