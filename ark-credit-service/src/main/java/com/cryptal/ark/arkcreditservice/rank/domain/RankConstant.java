package com.cryptal.ark.arkcreditservice.rank.domain;

public enum RankConstant {

    COMPANY("公司",5L),
    STAKE_HOLDER("股东",4L),
    GOLDEN_LEVEL("黄金用户",3L),
    DIAMOND_LEVEL("钻石用户",2L),
    NORMAL_USER("普通用户",1L);

    private String name;

    private Long rankId;

    RankConstant(String name, Long rankId) {
        this.name = name;
        this.rankId = rankId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getRankId() {
        return rankId;
    }

    public void setRankId(Long rankId) {
        this.rankId = rankId;
    }
}
