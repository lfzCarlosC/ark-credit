package com.cryptal.ark.arkcreditservice.member.entity;

import cn.com.gome.cloud.openplatform.open.OpenConvertible;
import com.cryptal.ark.interfaze.member.domain.RankPermission;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RankPermissionEntity implements OpenConvertible<RankPermission> {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private Long rankId;

    private Long pushTypeId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRankId() {
        return rankId;
    }

    public void setRankId(Long rankId) {
        this.rankId = rankId;
    }

    public Long getPushTypeId() {
        return pushTypeId;
    }

    public void setPushTypeId(Long pushTypeId) {
        this.pushTypeId = pushTypeId;
    }

    @Override
    public RankPermission converter() {
        RankPermission rankPermission = new RankPermission();
        rankPermission.setId(id);
        rankPermission.setRankId(rankId);
        rankPermission.setPushTypeId(pushTypeId);
        return rankPermission;
    }

    public static RankPermissionEntity constructFrom(RankPermission rankPermission) {
        RankPermissionEntity rankPermissionEntity = new RankPermissionEntity();
        rankPermissionEntity.setId(rankPermission.getId());
        rankPermissionEntity.setRankId(rankPermission.getRankId());
        rankPermissionEntity.setPushTypeId(rankPermission.getPushTypeId());
        return rankPermissionEntity;
    }
}
