package com.cryptal.ark.arkcreditservice.order.request;

import java.math.BigDecimal;

public class CreateOrderRequest {

    /**
     * 用户ID
     */
    private long userId;

    /**
     * 商品ID
     */
    private long skuId;

    /**
     * 使用的积分
     */
    private BigDecimal price;

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getUserId() {
        return userId;
    }

    public long getSkuId() {
        return skuId;
    }

    public void setSkuId(long skuId) {
        this.skuId = skuId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}