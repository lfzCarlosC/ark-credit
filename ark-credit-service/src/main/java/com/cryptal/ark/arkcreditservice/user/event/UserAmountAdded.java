package com.cryptal.ark.arkcreditservice.user.event;

import org.springframework.context.ApplicationEvent;

import java.math.BigDecimal;

/**
 * 用户积分被增加
 */
public class UserAmountAdded extends ApplicationEvent {

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 用户新增积分
     */
    private BigDecimal amount;

    /**
     * 新增积分的原因
     */
    private String reason;

    public UserAmountAdded(Object source, Long userId, BigDecimal amount, String reason) {
        super(source);
        this.userId = userId;
        this.amount = amount;
        this.reason = reason;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
