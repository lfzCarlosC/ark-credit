package com.cryptal.ark.arkcreditservice.push.entity;

import cn.com.gome.cloud.openplatform.open.OpenConvertible;
import com.cryptal.ark.interfaze.push.domain.PushType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PushTypeEntity implements OpenConvertible<PushType> {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
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
    public PushType converter() {
        PushType pushType = new PushType();
        pushType.setId(id);
        pushType.setName(name);
        pushType.setIdentifier(identifier);
        return pushType;
    }

    public static PushTypeEntity constructFrom(PushType pushType) {
        PushTypeEntity pushTypeEntity = new PushTypeEntity();
        pushTypeEntity.setId(pushType.getId());
        pushTypeEntity.setName(pushType.getName());
        pushTypeEntity.setIdentifier(pushType.getIdentifier());
        return pushTypeEntity;
    }

}
