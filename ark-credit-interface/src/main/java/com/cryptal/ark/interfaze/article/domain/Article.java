package com.cryptal.ark.interfaze.article.domain;

import java.io.Serializable;

public class Article implements Serializable {

    private Long id;

    /**
     * 标题
     */
    private String name;

    /**
     * 版块ID
     */
    private Long categoryId;

    /**
     * 图片地址
     */
    private String imagePath;

    /**
     * 排序号
     */
    private Integer sortNo;

    /**
     * 正文
     */
    private String content;

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

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Integer getSortNo() {
        return sortNo;
    }

    public void setSortNo(Integer sortNo) {
        this.sortNo = sortNo;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
