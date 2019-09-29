package com.cryptal.ark.arkcreditservice.article.dubbo;

import cn.com.gome.cloud.openplatform.common.Order;
import cn.com.gome.cloud.openplatform.common.PageObject;
import cn.com.gome.cloud.openplatform.common.SearchFilter;
import cn.com.gome.cloud.openplatform.open.OpenConverterUtils;
import com.alibaba.dubbo.config.annotation.Service;
import com.cryptal.ark.arkcreditservice.article.entity.ArticleEntity;
import com.cryptal.ark.arkcreditservice.article.service.ArticleService;
import com.cryptal.ark.interfaze.article.domain.Article;
import com.cryptal.ark.interfaze.article.dubbo.ArticleDubboService;
import org.springframework.beans.factory.annotation.Autowired;

@Service(group="ark-credit-service")
public class ArticleDubboServiceImpl implements ArticleDubboService {

    @Autowired
    private ArticleService articleService;

    @Override
    public PageObject<Article> paged(SearchFilter searchFilter) {
        searchFilter.add(Order.asc("sortNo"));
        return OpenConverterUtils.convertPageObject(articleService.paged(searchFilter));
    }

    @Override
    public Article get(Long id) {
        return OpenConverterUtils.convertObject(articleService.get(id));
    }

    @Override
    public Article get(SearchFilter searchFilter) {
        return OpenConverterUtils.convertObject(articleService.get(searchFilter));
    }

    @Override
    public void saveOrUpdate(Article article) {
        articleService.insert(ArticleEntity.constructFrom(article));
    }

    @Override
    public void delete(Long id) {
        articleService.delete(id);
    }
}
