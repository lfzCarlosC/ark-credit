package com.cryptal.ark.arkcreditservice.member.event;

import org.springframework.context.ApplicationEvent;

/**
 * 用户会员已过期
 */
public class MemberExpired extends ApplicationEvent {

    private Long userId;

    public MemberExpired(Object source, Long userId) {
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
