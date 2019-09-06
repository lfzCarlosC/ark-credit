package com.cryptal.ark.arkcreditservice.push.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PushType {

    @Id
    private Long id;

    private String typeName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
