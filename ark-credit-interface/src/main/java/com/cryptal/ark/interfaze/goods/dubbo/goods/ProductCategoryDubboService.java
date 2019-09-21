package com.cryptal.ark.interfaze.goods.dubbo.goods;

import cn.com.gome.cloud.openplatform.common.PageObject;
import cn.com.gome.cloud.openplatform.common.SearchFilter;
import com.cryptal.ark.interfaze.goods.domain.ProductCategory;

import java.util.List;

public interface ProductCategoryDubboService {

    PageObject<ProductCategory> paged(SearchFilter searchFilter);

    ProductCategory get(Long id);

    ProductCategory get(SearchFilter searchFilter);

    List<ProductCategory> findAllEnable();

    void saveOrUpdate(ProductCategory productCategory);

    void delete(Long id);
}
