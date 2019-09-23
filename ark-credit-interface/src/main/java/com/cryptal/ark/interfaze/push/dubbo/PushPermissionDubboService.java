package com.cryptal.ark.interfaze.push.dubbo;

import cn.com.gome.cloud.openplatform.common.PageObject;
import cn.com.gome.cloud.openplatform.common.SearchFilter;
import com.cryptal.ark.interfaze.push.domain.PushPermission;

public interface PushPermissionDubboService {

    PageObject<PushPermission> page(SearchFilter searchFilter);

    PushPermission get(Long id);

    PushPermission get(SearchFilter searchFilter);

    void saveOrUpdate(PushPermission pushPermission);

    void delete(Long id);
}
