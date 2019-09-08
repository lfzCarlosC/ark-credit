package com.cryptal.ark.arkcreditservice.order.event;

import org.springframework.context.ApplicationEvent;

public class OrderCreated extends ApplicationEvent {

    private Long orderId;

    private Long goodsId;

    private Long userId;

    private Long credit;

    private Long count;

    public OrderCreated(Object source, Long orderId, Long goodsId, Long userId,Long credit,Long count) {
        super(source);
        this.orderId = orderId;
        this.goodsId = goodsId;
        this.userId = userId;
        this.credit = credit;
        this.count = count;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCredit() {
        return credit;
    }

    public void setCredit(Long credit) {
        this.credit = credit;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
