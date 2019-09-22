package com.cryptal.ark.arkcreditservice.member.entity;

import cn.com.gome.cloud.openplatform.open.OpenConvertible;
import com.cryptal.ark.interfaze.member.domain.MemberRank;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 会员等级
 */
@Entity
public class MemberRankEntity implements OpenConvertible<MemberRank> {

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

    public MemberRankEntity() {
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
    public MemberRank converter() {
        MemberRank memberRank = new MemberRank();
        memberRank.setId(id);
        memberRank.setName(name);
        memberRank.setRebatePercentLevel1(rebatePercentLevel1);
        memberRank.setRebatePercentLevel2(rebatePercentLevel2);
        memberRank.setRebatePercentLevel3(rebatePercentLevel3);
        return memberRank;
    }

    public static MemberRankEntity constructFrom(MemberRank memberRank) {
        MemberRankEntity memberRankEntity = new MemberRankEntity();
        memberRankEntity.setId(memberRank.getId());
        memberRankEntity.setName(memberRank.getName());
        memberRankEntity.setRebatePercentLevel1(memberRank.getRebatePercentLevel1());
        memberRankEntity.setRebatePercentLevel2(memberRank.getRebatePercentLevel2());
        memberRankEntity.setRebatePercentLevel3(memberRank.getRebatePercentLevel3());
        return memberRankEntity;
    }
}
