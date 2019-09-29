package com.cryptal.ark.interfaze.goods.domain;

import java.io.Serializable;

public class GoodsSellAttribute implements Serializable {

    private Long id;

    private Long skuId;

    private Long sellAttributeId;

    private Long sellAttributeValueId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public Long getSellAttributeId() {
        return sellAttributeId;
    }

    public void setSellAttributeId(Long sellAttributeId) {
        this.sellAttributeId = sellAttributeId;
    }

    public Long getSellAttributeValueId() {
        return sellAttributeValueId;
    }

    public void setSellAttributeValueId(Long sellAttributeValueId) {
        this.sellAttributeValueId = sellAttributeValueId;
    }
}
