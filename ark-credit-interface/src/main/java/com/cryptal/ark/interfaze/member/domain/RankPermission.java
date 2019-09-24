package com.cryptal.ark.interfaze.member.domain;

import java.io.Serializable;

public class RankPermission implements Serializable {

    private Long id;

    private Long rankId;

    private Long pushTypeId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPushTypeId() {
        return pushTypeId;
    }

    public void setPushTypeId(Long pushTypeId) {
        this.pushTypeId = pushTypeId;
    }

    public Long getRankId() {
        return rankId;
    }

    public void setRankId(Long rankId) {
        this.rankId = rankId;
    }
}
