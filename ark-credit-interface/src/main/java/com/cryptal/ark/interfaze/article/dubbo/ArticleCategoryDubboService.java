package com.cryptal.ark.interfaze.article.dubbo;

import cn.com.gome.cloud.openplatform.common.PageObject;
import cn.com.gome.cloud.openplatform.common.SearchFilter;
import com.cryptal.ark.interfaze.article.domain.ArticleCategory;

import java.util.List;

public interface ArticleCategoryDubboService {

    ArticleCategory get(Long id);

    ArticleCategory get(SearchFilter searchFilter);

    PageObject<ArticleCategory> page(SearchFilter searchFilter);

    void delete(Long id);

    void saveOrUpdate(ArticleCategory articleCategory);

    List<ArticleCategory> findAll();
}
