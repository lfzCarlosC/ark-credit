package com.cryptal.ark.arkcreditservice.member.event;

import org.springframework.context.ApplicationEvent;

public class MemberRankOrdered extends ApplicationEvent{

    /**
     * 等级ID
     */
    private Long skuId;

    /**
     * 用户ID
     */
    private Long userId;

    public MemberRankOrdered(Object source, Long skuId, Long userId) {
        super(source);
        this.skuId = skuId;
        this.userId = userId;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
