package com.cryptal.ark.arkcreditservice.goods.service.impl;

import cn.com.gome.cloud.openplatform.common.SearchFilter;
import cn.com.gome.cloud.openplatform.repository.GenericDao;
import cn.com.gome.cloud.openplatform.service.impl.GenericServiceImpl;
import com.cryptal.ark.arkcreditservice.goods.dao.ProductCategoryDao;
import com.cryptal.ark.arkcreditservice.goods.entity.ProductCategoryEntity;
import com.cryptal.ark.arkcreditservice.goods.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductCategoryServiceImpl extends GenericServiceImpl<ProductCategoryEntity,Long> implements ProductCategoryService {

    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Override
    protected GenericDao<ProductCategoryEntity, Long> getDao() {
        return productCategoryDao;
    }

    @Override
    public List<ProductCategoryEntity> findAllEnable() {
        SearchFilter searchFilter = SearchFilter.getDefault();
        return this.list(searchFilter);
    }

}
