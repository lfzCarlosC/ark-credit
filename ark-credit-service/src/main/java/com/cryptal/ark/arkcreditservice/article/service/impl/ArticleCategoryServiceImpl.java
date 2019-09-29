package com.cryptal.ark.arkcreditservice.article.service.impl;

import cn.com.gome.cloud.openplatform.repository.GenericDao;
import cn.com.gome.cloud.openplatform.service.impl.GenericServiceImpl;
import com.cryptal.ark.arkcreditservice.article.dao.ArticleCategoryDao;
import com.cryptal.ark.arkcreditservice.article.entity.ArticleCategoryEntity;
import com.cryptal.ark.arkcreditservice.article.service.ArticleCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ArticleCategoryServiceImpl extends GenericServiceImpl<ArticleCategoryEntity,Long> implements ArticleCategoryService {

    @Autowired
    private ArticleCategoryDao articleCategoryDao;

    @Override
    protected GenericDao<ArticleCategoryEntity, Long> getDao() {
        return articleCategoryDao;
    }

}
