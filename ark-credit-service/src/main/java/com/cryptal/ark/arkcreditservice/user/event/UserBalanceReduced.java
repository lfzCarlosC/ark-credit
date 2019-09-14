package com.cryptal.ark.arkcreditservice.user.event;

import org.springframework.context.ApplicationEvent;

import java.math.BigDecimal;

/**
 * 用户积分被减少
 */
public class UserBalanceReduced extends ApplicationEvent {

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 用户新增积分
     */
    private BigDecimal paymentAmount;

    /**
     * 新增积分的原因
     */
    private String reason;

    public UserBalanceReduced(Object source, Long userId, BigDecimal credit, String reason) {
        super(source);
        this.userId = userId;
        this.paymentAmount = credit;
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

    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }
}
