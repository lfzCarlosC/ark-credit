package com.cryptal.ark.arkcreditservice.goods.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Sku implements Serializable {

    @Id
    private Long id;

    /**
     * 商品名称
     */
    private Long goodsId;

    /**
     * Sku名称
     */
    private String skuName;

    /**
     * 所需积分
     */
    private Long credit;

    /**
     * 库存数
     */
    private Long stock;

    /**
     * 是否在售
     */
    private boolean onSale;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    public Long getCredit() {
        return credit;
    }

    public void setCredit(Long credit) {
        this.credit = credit;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public boolean isOnSale() {
        return onSale;
    }

    public void setOnSale(boolean onSale) {
        this.onSale = onSale;
    }
}
