package com.cryptal.ark.arkcreditservice.goods.entity;

import cn.com.gome.cloud.openplatform.open.OpenConvertible;
import com.cryptal.ark.interfaze.goods.domain.SellAttribute;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SellAttributeEntity implements OpenConvertible<SellAttribute> {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long categoryId;

    private Integer sortNum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSortNum() {
        return sortNum;
    }

    public void setSortNum(Integer sortNum) {
        this.sortNum = sortNum;
    }

    @Override
    public SellAttribute converter() {
        SellAttribute sellAttribute = new SellAttribute();
        sellAttribute.setId(id);
        sellAttribute.setName(name);
        sellAttribute.setCategoryId(categoryId);
        sellAttribute.setSortNum(sortNum);
        return sellAttribute;
    }

    public static SellAttributeEntity constructFrom(SellAttribute sellAttribute) {
        SellAttributeEntity sellAttributeEntity = new SellAttributeEntity();
        sellAttributeEntity.setId(sellAttribute.getId());
        sellAttributeEntity.setCategoryId(sellAttribute.getCategoryId());
        sellAttributeEntity.setName(sellAttribute.getName());
        sellAttributeEntity.setSortNum(sellAttribute.getSortNum());
        return sellAttributeEntity;
    }
}
