package com.cryptal.ark.arkcreditservice.member.entity;

import cn.com.gome.cloud.openplatform.open.OpenConvertible;
import com.cryptal.ark.interfaze.member.domain.Rank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 会员等级
 */
@Entity
public class RankEntity implements OpenConvertible<Rank> {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 一级分销百分比
     */
    private int rebatePercentLevel1;

    /**
     * 二级分销百分比
     */
    private int rebatePercentLevel2;

    /**
     * 三级分销百分比
     */
    private int rebatePercentLevel3;

    public RankEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRebatePercentLevel1() {
        return rebatePercentLevel1;
    }

    public void setRebatePercentLevel1(int rebatePercentLevel1) {
        this.rebatePercentLevel1 = rebatePercentLevel1;
    }

    public int getRebatePercentLevel2() {
        return rebatePercentLevel2;
    }

    public void setRebatePercentLevel2(int rebatePercentLevel2) {
        this.rebatePercentLevel2 = rebatePercentLevel2;
    }

    public int getRebatePercentLevel3() {
        return rebatePercentLevel3;
    }

    public void setRebatePercentLevel3(int rebatePercentLevel3) {
        this.rebatePercentLevel3 = rebatePercentLevel3;
    }

    @Override
    public Rank converter() {
        Rank rank = new Rank();
        rank.setId(id);
        rank.setName(name);
        rank.setRebatePercentLevel1(rebatePercentLevel1);
        rank.setRebatePercentLevel2(rebatePercentLevel2);
        rank.setRebatePercentLevel3(rebatePercentLevel3);
        return rank;
    }

    public static RankEntity constructFrom(Rank rank) {
        RankEntity rankEntity = new RankEntity();
        rankEntity.setId(rank.getId());
        rankEntity.setName(rank.getName());
        rankEntity.setRebatePercentLevel1(rank.getRebatePercentLevel1());
        rankEntity.setRebatePercentLevel2(rank.getRebatePercentLevel2());
        rankEntity.setRebatePercentLevel3(rank.getRebatePercentLevel3());
        return rankEntity;
    }
}
