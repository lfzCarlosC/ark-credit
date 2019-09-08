package com.cryptal.ark.arkcreditservice.rank.domain;

import com.cryptal.ark.arkcreditservice.common.CommonEnum;

public enum RankConstant implements CommonEnum {

    COMPANY(5,"COMPANY","公司",5L),
    STOCK_HOLDER(4,"STOCK_HOLDER","股东",4L),
    GOLDEN_LEVEL(3,"GOLDEN_LEVEL","黄金用户",3L),
    DIAMOND_LEVEL(2,"DIAMOND_LEVEL","钻石用户",2L),
    NORMAL_USER(1,"","普通用户",1L);

    private int code;

    private String name;

    private String desc;

    private Long rankId;

    RankConstant(int code, String name, String desc, Long rankId) {
        this.code = code;
        this.name = name;
        this.desc = desc;
        this.rankId = rankId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Long getRankId() {
        return rankId;
    }

    public void setRankId(Long rankId) {
        this.rankId = rankId;
    }

    @Override
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
