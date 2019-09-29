package com.cryptal.ark.arkcreditservice.article.service.impl;

import cn.com.gome.cloud.openplatform.repository.GenericDao;
import cn.com.gome.cloud.openplatform.service.impl.GenericServiceImpl;
import com.cryptal.ark.arkcreditservice.article.dao.ArticleDao;
import com.cryptal.ark.arkcreditservice.article.entity.ArticleEntity;
import com.cryptal.ark.arkcreditservice.article.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ArticleServiceImpl extends GenericServiceImpl<ArticleEntity,Long> implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Override
    protected GenericDao<ArticleEntity, Long> getDao() {
        return articleDao;
    }

}
