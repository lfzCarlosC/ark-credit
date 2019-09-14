package com.cryptal.ark.arkcreditservice.rank.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 会员等级订单
 */
@Entity
public class RankOrder implements Serializable {

    @Id
    private Long id;

    /**
     * 等级ID
     */
    private Long rankId;

    /**
     * 支付金额
     */
    private BigDecimal price;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 下单时间
     */
    private Date orderTime;



}
