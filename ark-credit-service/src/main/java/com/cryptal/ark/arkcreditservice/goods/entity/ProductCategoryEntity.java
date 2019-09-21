package com.cryptal.ark.arkcreditservice.goods.entity;

import cn.com.gome.cloud.openplatform.open.OpenConvertible;
import com.cryptal.ark.interfaze.goods.domain.ProductCategory;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 商品分类
 */
@Entity
public class ProductCategoryEntity implements OpenConvertible<ProductCategory> {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long parentId;

    private String brief;

    private boolean enable;

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

    @Override
    public ProductCategory converter() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setId(id);
        productCategory.setName(name);
        productCategory.setBrief(brief);
        productCategory.setParentId(parentId);
        productCategory.setEnable(enable);
        return productCategory;
    }

    public static ProductCategoryEntity constructFrom(ProductCategory productCategory) {
        ProductCategoryEntity productCategoryEntity = new ProductCategoryEntity();
        productCategoryEntity.setId(productCategory.getId());
        productCategoryEntity.setName(productCategory.getName());
        productCategoryEntity.setParentId(productCategory.getParentId());
        productCategoryEntity.setBrief(productCategory.getBrief());
        productCategoryEntity.setEnable(productCategory.isEnable());
        return productCategoryEntity;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
