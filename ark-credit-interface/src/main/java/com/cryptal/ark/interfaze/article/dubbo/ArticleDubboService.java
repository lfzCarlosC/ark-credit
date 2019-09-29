package com.cryptal.ark.interfaze.article.dubbo;

import cn.com.gome.cloud.openplatform.common.PageObject;
import cn.com.gome.cloud.openplatform.common.SearchFilter;
import com.cryptal.ark.interfaze.article.domain.Article;

public interface ArticleDubboService {

    PageObject<Article> paged(SearchFilter searchFilter);

    Article get(Long id);

    Article get(SearchFilter searchFilter);

    void saveOrUpdate(Article article);

    void delete(Long id);

}
