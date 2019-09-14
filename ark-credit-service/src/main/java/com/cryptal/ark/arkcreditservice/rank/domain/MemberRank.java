package com.cryptal.ark.arkcreditservice.rank.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * 会员等级
 */
@Entity
public class MemberRank implements Serializable {

    @Id
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

    public MemberRank() {
    }

    public MemberRank(Long rankId, String name) {

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
}
