package com.cryptal.ark.arkcreditservice.user.event;

import org.springframework.context.ApplicationEvent;

/**
 * 用户已注册
 */
public class UserRegistered extends ApplicationEvent {

    /**
     * 新增用户ID
     */
    private Long userId;


    /**
     * 被邀请人的用户ID
     */
    private Long invitedUserId;

    public UserRegistered(Object source,Long userId,Long invitedUserId) {
        super(source);
        this.userId = userId;
        this.invitedUserId = invitedUserId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getInvitedUserId() {
        return invitedUserId;
    }

    public void setInvitedUserId(Long invitedUserId) {
        this.invitedUserId = invitedUserId;
    }
}
