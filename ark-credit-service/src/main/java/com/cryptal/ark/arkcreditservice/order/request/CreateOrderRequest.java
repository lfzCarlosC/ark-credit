package com.cryptal.ark.arkcreditservice.order.request;

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
    private long credit;

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

    public long getCredit() {
        return credit;
    }

    public void setCredit(long credit) {
        this.credit = credit;
    }
}
