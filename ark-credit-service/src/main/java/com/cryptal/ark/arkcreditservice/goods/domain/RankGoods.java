package com.cryptal.ark.arkcreditservice.goods.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * 等级商品
 */
@Entity
public class RankGoods implements Serializable {

    @Id
    private Long id;

    /**
     * 商品ID
     */
    private String goodsId;

    /**
     * 商品对应的等级ID
     */
    private Long rankId;

    /**
     * 购买时长
     */
    private int days;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public Long getRankId() {
        return rankId;
    }

    public void setRankId(Long rankId) {
        this.rankId = rankId;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }
}
