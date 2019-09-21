package com.cryptal.ark.interfaze.goods.domain;

import cn.com.gome.page.domain.CategoryEntity;

/**
 * 商品分类
 */
public class ProductCategory implements CategoryEntity {

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
    public boolean isRootElement() {
        return parentId == 0 ;
    }

    @Override
    public String getNodeId() {
        return String.valueOf(id);
    }

    @Override
    public String getParentNodeId() {
        return String.valueOf(parentId);
    }

    @Override
    public String getNodeName() {
        return name;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
