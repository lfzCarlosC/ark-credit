package com.cryptal.ark.arkcreditservice.credit.event;

import org.springframework.context.ApplicationEvent;

/**
 * 用户积分被增加
 */
public class UserCreditAdded extends ApplicationEvent {

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 用户新增积分
     */
    private int credit;

    /**
     * 新增积分的原因
     */
    private String reason;

    public UserCreditAdded(Object source,Long userId,int credit,String reason) {
        super(source);
        this.userId = userId;
        this.credit = credit;
        this.reason = reason;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
