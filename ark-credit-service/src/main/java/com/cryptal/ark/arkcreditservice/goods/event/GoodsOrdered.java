package com.cryptal.ark.arkcreditservice.goods.event;

import org.springframework.context.ApplicationEvent;

/**
 * 商品被下单
 */
public class GoodsOrdered extends ApplicationEvent {

    private Long goodsId;

    private Long userId;

    public GoodsOrdered(Object source) {
        super(source);
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
}
