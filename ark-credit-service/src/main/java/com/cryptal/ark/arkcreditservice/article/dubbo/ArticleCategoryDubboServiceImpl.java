package com.cryptal.ark.arkcreditservice.article.dubbo;

import cn.com.gome.cloud.openplatform.common.Order;
import cn.com.gome.cloud.openplatform.common.PageObject;
import cn.com.gome.cloud.openplatform.common.SearchFilter;
import cn.com.gome.cloud.openplatform.open.OpenConverterUtils;
import com.alibaba.dubbo.config.annotation.Service;
import com.cryptal.ark.arkcreditservice.article.entity.ArticleCategoryEntity;
import com.cryptal.ark.arkcreditservice.article.service.ArticleCategoryService;
import com.cryptal.ark.interfaze.article.domain.ArticleCategory;
import com.cryptal.ark.interfaze.article.dubbo.ArticleCategoryDubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service(group="ark-credit-service")
public class ArticleCategoryDubboServiceImpl implements ArticleCategoryDubboService {

    @Autowired
    private ArticleCategoryService articleCategoryService;

    @Override
    public PageObject<ArticleCategory> page(SearchFilter searchFilter) {
        searchFilter.add(Order.asc("sortNo"));
        return OpenConverterUtils.convertPageObject(articleCategoryService.paged(searchFilter));
    }

    @Override
    public ArticleCategory get(Long id) {
        return OpenConverterUtils.convertObject(articleCategoryService.get(id));
    }

    @Override
    public ArticleCategory get(SearchFilter searchFilter) {
        return OpenConverterUtils.convertObject(articleCategoryService.get(searchFilter));
    }


    @Override
    public void saveOrUpdate(ArticleCategory articleCategory) {
        articleCategoryService.insert(ArticleCategoryEntity.constructFrom(articleCategory));
    }

    @Override
    public List<ArticleCategory> findAll() {

        SearchFilter searchFilter = SearchFilter.getDefault();
        searchFilter.add(Order.asc("sortNo"));
        return OpenConverterUtils.convertList(articleCategoryService.list(searchFilter));
    }

    @Override
    public void delete(Long id) {
        articleCategoryService.delete(id);
    }
}
