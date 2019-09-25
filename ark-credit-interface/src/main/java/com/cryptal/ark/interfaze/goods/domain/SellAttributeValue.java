package com.cryptal.ark.interfaze.goods.domain;

import java.io.Serializable;

public class SellAttributeValue implements Serializable {

    private Long id;

    /**
     * 分类ID
     */
    private Long categoryId;

    /**
     * 销售属性ID
     */
    private Long attributeId;

    private Integer sortNum;

    /**
     * 销售属性正文
     */
    private String attributeValue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(Long attributeId) {
        this.attributeId = attributeId;
    }

    public String getAttributeValue() {
        return attributeValue;
    }

    public void setAttributeValue(String attributeValue) {
        this.attributeValue = attributeValue;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getSortNum() {
        return sortNum;
    }

    public void setSortNum(Integer sortNum) {
        this.sortNum = sortNum;
    }
}
