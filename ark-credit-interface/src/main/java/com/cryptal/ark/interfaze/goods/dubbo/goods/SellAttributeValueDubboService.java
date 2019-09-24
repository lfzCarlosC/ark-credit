package com.cryptal.ark.interfaze.goods.dubbo.goods;

import cn.com.gome.cloud.openplatform.common.PageObject;
import cn.com.gome.cloud.openplatform.common.SearchFilter;
import com.cryptal.ark.interfaze.goods.domain.SellAttributeValue;

import java.util.List;

public interface SellAttributeValueDubboService {

    PageObject<SellAttributeValue> page(SearchFilter searchFilter);

    SellAttributeValue get(Long id);

    SellAttributeValue get(SearchFilter searchFilter);

    void saveOrUpdate(SellAttributeValue sellAttributeValue);

    void delete(Long id);

    List<SellAttributeValue> findByAttributeId(Long sellAttributeId);
}
