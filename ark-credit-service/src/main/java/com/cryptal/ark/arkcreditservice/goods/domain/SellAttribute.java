package com.cryptal.ark.arkcreditservice.goods.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class SellAttribute implements Serializable {

    @Id
    private Long id;

    private String name;

    private Long sellCategoryId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSellCategoryId() {
        return sellCategoryId;
    }

    public void setSellCategoryId(Long sellCategoryId) {
        this.sellCategoryId = sellCategoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
