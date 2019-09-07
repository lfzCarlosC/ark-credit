package com.cryptal.ark.arkcreditservice.user.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class UserMessage implements Serializable {

    @Id
    private long id;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 消息的具体内容
     */
    private String message;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
