package com.cryptal.ark.arkcreditservice.goods.event;

import org.springframework.context.ApplicationEvent;

public class GoodsCreated extends ApplicationEvent {

    private Long goodsId;

    public GoodsCreated(Object source,Long goodsId) {
        super(source);
        this.goodsId = goodsId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

}
