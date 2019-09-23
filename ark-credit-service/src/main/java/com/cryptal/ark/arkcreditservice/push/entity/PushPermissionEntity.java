package com.cryptal.ark.arkcreditservice.push.entity;

import cn.com.gome.cloud.openplatform.open.OpenConvertible;
import com.cryptal.ark.interfaze.push.domain.PushPermission;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PushPermissionEntity implements OpenConvertible<PushPermission> {

    @Id
    private Long id;

    private String name;

    private String identifier;


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

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public PushPermission converter() {
        PushPermission pushPermission = new PushPermission();
        pushPermission.setId(id);
        pushPermission.setName(name);
        pushPermission.setIdentifier(identifier);
        return pushPermission;
    }

    public static PushPermissionEntity constructFrom(PushPermission pushPermission) {
        PushPermissionEntity pushPermissionEntity = new PushPermissionEntity();
        pushPermissionEntity.setId(pushPermission.getId());
        pushPermissionEntity.setName(pushPermission.getName());
        pushPermissionEntity.setIdentifier(pushPermission.getIdentifier());
        return pushPermissionEntity;
    }

}
