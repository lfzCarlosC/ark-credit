package com.cryptal.ark.interfaze.goods.dubbo.goods;

import cn.com.gome.cloud.openplatform.common.PageObject;
import cn.com.gome.cloud.openplatform.common.SearchFilter;
import com.cryptal.ark.interfaze.goods.domain.Product;

public interface ProductDubboService {

    PageObject<Product> paged(SearchFilter searchFilter);

    Product get(Long id);

    Product get(SearchFilter searchFilter);

    void saveOrUpdate(Product product);

    void delete(Long id);

}
