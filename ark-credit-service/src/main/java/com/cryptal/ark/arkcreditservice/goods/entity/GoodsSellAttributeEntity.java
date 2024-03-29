package com.cryptal.ark.arkcreditservice.goods.entity;

import cn.com.gome.cloud.openplatform.open.OpenConvertible;
import com.cryptal.ark.interfaze.goods.domain.GoodsSellAttribute;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GoodsSellAttributeEntity implements OpenConvertible<GoodsSellAttribute> {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
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

    @Override
    public GoodsSellAttribute converter() {
        GoodsSellAttribute goodsSellAttribute = new GoodsSellAttribute();
        goodsSellAttribute.setId(id);
        goodsSellAttribute.setSkuId(skuId);
        goodsSellAttribute.setSellAttributeId(sellAttributeId);
        goodsSellAttribute.setSellAttributeValueId(sellAttributeValueId);
        return goodsSellAttribute;
    }
}
