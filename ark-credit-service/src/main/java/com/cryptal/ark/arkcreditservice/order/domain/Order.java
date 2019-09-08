package com.cryptal.ark.arkcreditservice.order.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "credit_order")
public class Order implements Serializable {

    @Id
    private Long id;

    /**
     * 所属用户
     */
    private Long userId;

    /**
     * 商品ID
     */
    private Long skuId;

    /**
     * 数量
     */
    private Long skuNum;

    /**
     * 使用的积分
     */
    private Long credit;

    /**
     * 下单时间
     */
    private Date orderTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCredit() {
        return credit;
    }

    public void setCredit(Long credit) {
        this.credit = credit;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public Long getSkuNum() {
        return skuNum;
    }

    public void setSkuNum(Long skuNum) {
        this.skuNum = skuNum;
    }
}
