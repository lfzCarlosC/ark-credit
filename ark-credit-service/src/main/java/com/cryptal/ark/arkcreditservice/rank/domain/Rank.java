package com.cryptal.ark.arkcreditservice.rank.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * 等级
 */
@Entity
public class Rank implements Serializable {

    @Id
    private Long id;

    private String name;

    /**
     * 回扣比例
     */
    private Double rebateRatio;

    public Rank() {
    }

    public Rank(Long rankId, String name) {

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
}
