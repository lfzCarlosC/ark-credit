package com.cryptal.ark.arkcreditservice.order.event;

import org.springframework.context.ApplicationEvent;

import java.math.BigDecimal;

/**
 * 订单被创建
 */
public class OrderCreated extends ApplicationEvent {

    /**
     * 订单ID
     */
    private Long orderId;

    /**
     * 商品ID
     */
    private Long goodsId;

    /**
     * SKU ID
     */
    private Long skuId;

    /**
     * 下单用户
     */
    private Long userId;

    /**
     * 交易总额
     */
    private BigDecimal paymentAmount;

    /**
     * 购买数量
     */
    private Long count;

    public OrderCreated(Object source, Long orderId, Long goodsId, Long userId, BigDecimal paymentAmount, Long count) {
        super(source);
        this.orderId = orderId;
        this.goodsId = goodsId;
        this.userId = userId;
        this.paymentAmount = paymentAmount;
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



    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }
}
