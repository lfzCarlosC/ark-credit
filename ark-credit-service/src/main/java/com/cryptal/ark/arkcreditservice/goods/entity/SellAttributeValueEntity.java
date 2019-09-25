package com.cryptal.ark.arkcreditservice.goods.entity;

import cn.com.gome.cloud.openplatform.open.OpenConvertible;
import com.cryptal.ark.interfaze.goods.domain.SellAttributeValue;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SellAttributeValueEntity implements OpenConvertible<SellAttributeValue> {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    /**
     * 销售属性ID
     */
    private Long attributeId;

    /**
     * 分类ID
     */
    private Long categoryId;

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

    @Override
    public SellAttributeValue converter() {
        SellAttributeValue sellAttributeValue = new SellAttributeValue();
        sellAttributeValue.setId(id);
        sellAttributeValue.setCategoryId(categoryId);
        sellAttributeValue.setAttributeId(attributeId);
        sellAttributeValue.setAttributeValue(attributeValue);
        sellAttributeValue.setSortNum(sortNum);
        return sellAttributeValue;
    }

    public static SellAttributeValueEntity constructFrom(SellAttributeValue sellAttributeValue) {

        SellAttributeValueEntity sellAttributeValueEntity = new SellAttributeValueEntity();
        sellAttributeValueEntity.setId(sellAttributeValue.getId());
        sellAttributeValueEntity.setCategoryId(sellAttributeValue.getCategoryId());
        sellAttributeValueEntity.setAttributeId(sellAttributeValue.getAttributeId());
        sellAttributeValueEntity.setAttributeValue(sellAttributeValue.getAttributeValue());
        sellAttributeValueEntity.setSortNum(sellAttributeValue.getSortNum());
        return sellAttributeValueEntity;

    }


}
