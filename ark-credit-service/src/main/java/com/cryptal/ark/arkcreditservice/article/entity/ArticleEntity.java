package com.cryptal.ark.arkcreditservice.article.entity;

import cn.com.gome.cloud.openplatform.open.OpenConvertible;
import com.cryptal.ark.interfaze.article.domain.Article;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ArticleEntity implements OpenConvertible<Article> {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
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

    public static ArticleEntity constructFrom(Article article) {
        ArticleEntity articleEntity = new ArticleEntity();
        articleEntity.setId(article.getId());
        articleEntity.setName(article.getName());
        articleEntity.setCategoryId(article.getCategoryId());
        articleEntity.setImagePath(article.getImagePath());
        articleEntity.setSortNo(article.getSortNo());
        articleEntity.setContent(article.getContent());
        return articleEntity;
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

    @Override
    public Article converter() {
        Article article = new Article();
        article.setId(id);
        article.setName(name);
        article.setCategoryId(categoryId);
        article.setImagePath(imagePath);
        article.setSortNo(sortNo);
        article.setContent(content);
        return article;
    }

}
