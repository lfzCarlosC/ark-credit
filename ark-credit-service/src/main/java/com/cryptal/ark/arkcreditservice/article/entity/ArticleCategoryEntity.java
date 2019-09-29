package com.cryptal.ark.arkcreditservice.article.entity;

import cn.com.gome.cloud.openplatform.open.OpenConvertible;
import com.cryptal.ark.interfaze.article.domain.ArticleCategory;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ArticleCategoryEntity implements OpenConvertible<ArticleCategory> {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String identifier;

    private Integer sortNo;

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

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public Integer getSortNo() {
        return sortNo;
    }

    public void setSortNo(Integer sortNo) {
        this.sortNo = sortNo;
    }

    @Override
    public ArticleCategory converter() {
        ArticleCategory articleCategory = new ArticleCategory();
        articleCategory.setId(id);
        articleCategory.setName(name);
        articleCategory.setSortNo(sortNo);
        articleCategory.setIdentifier(identifier);
        return articleCategory;
    }


    public static ArticleCategoryEntity constructFrom(ArticleCategory articleCategory) {
        ArticleCategoryEntity articleCategoryEntity = new ArticleCategoryEntity();
        articleCategoryEntity.setId(articleCategory.getId());
        articleCategoryEntity.setName(articleCategory.getName());
        articleCategoryEntity.setIdentifier(articleCategory.getIdentifier());
        articleCategoryEntity.setSortNo(articleCategory.getSortNo());
        return articleCategoryEntity;
    }
}
