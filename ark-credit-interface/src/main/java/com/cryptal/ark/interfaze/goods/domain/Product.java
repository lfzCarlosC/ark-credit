package com.cryptal.ark.interfaze.goods.domain;

import java.io.Serializable;

public class Product implements Serializable {

    private Long id;

    private String name;

    /**
     * 分类ID
     */
    private Long categoryId;


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

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
