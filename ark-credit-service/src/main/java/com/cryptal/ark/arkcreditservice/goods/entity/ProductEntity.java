package com.cryptal.ark.arkcreditservice.goods.entity;

import cn.com.gome.cloud.openplatform.open.OpenConvertible;
import com.cryptal.ark.interfaze.goods.domain.Product;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class ProductEntity implements OpenConvertible<Product> {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;

    /**
     * 分类ID
     */
    private Long categoryId;

    /**
     * 描述
     */
    private String content;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 修改时间
     */
    private Date modifyTime;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public Product converter() {
        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setCategoryId(categoryId);
        product.setContent(content);
        product.setCreatedTime(createdTime);
        product.setModifyTime(modifyTime);
        return product;
    }


    public static ProductEntity constructFrom(Product product) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(product.getId());
        productEntity.setName(product.getName());
        productEntity.setCategoryId(product.getCategoryId());
        productEntity.setContent(product.getContent());
        productEntity.setCreatedTime(product.getCreatedTime());
        productEntity.setModifyTime(product.getModifyTime());
        return productEntity;
    }
}
