package com.cryptal.ark.interfaze.goods.dubbo.goods;

import cn.com.gome.cloud.openplatform.common.PageObject;
import cn.com.gome.cloud.openplatform.common.SearchFilter;
import com.cryptal.ark.interfaze.goods.domain.SellAttribute;

import java.util.List;

public interface SellAttributeDubboService {

    PageObject<SellAttribute> page(SearchFilter searchFilter);

    SellAttribute get(Long id);

    SellAttribute get(SearchFilter searchFilter);

    void saveOrUpdate(SellAttribute sellAttribute);

    void delete(Long id);

    List<SellAttribute> findAll();

    List<SellAttribute> findByCategoryId(Long categoryId);
}
