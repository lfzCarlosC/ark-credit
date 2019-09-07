package com.cryptal.ark.arkcreditservice.user.event;

import org.springframework.context.ApplicationEvent;

/**
 * 用户会员已过期
 */
public class UserExpired extends ApplicationEvent {

    private Long userId;

    public UserExpired(Object source,Long userId) {
        super(source);
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
