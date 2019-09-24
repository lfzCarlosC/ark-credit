package com.cryptal.ark.interfaze.push.dubbo;

import cn.com.gome.cloud.openplatform.common.PageObject;
import cn.com.gome.cloud.openplatform.common.SearchFilter;
import com.cryptal.ark.interfaze.push.domain.PushType;

import java.util.List;

public interface PushTypeDubboService {

    PageObject<PushType> page(SearchFilter searchFilter);

    PushType get(Long id);

    PushType get(SearchFilter searchFilter);

    void saveOrUpdate(PushType pushType);

    void delete(Long id);

    List<PushType> findAll();
}
