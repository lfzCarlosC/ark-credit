package com.cryptal.ark.arkcreditservice.goods.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Goods {

    @Id
    private Long id;

    private String goodsName;

    private GoodsType goodsType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public GoodsType getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(GoodsType goodsType) {
        this.goodsType = goodsType;
    }
}
