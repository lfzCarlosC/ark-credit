package com.cryptal.ark.interfaze.member.dubbo;

import cn.com.gome.cloud.openplatform.common.PageObject;
import cn.com.gome.cloud.openplatform.common.SearchFilter;
import com.cryptal.ark.interfaze.member.domain.RankPermission;

public interface RankPermissionDubboService {

    RankPermission get(SearchFilter searchFilter);

    RankPermission get(Long id);

    PageObject<RankPermission> page(SearchFilter searchFilter);

    void saveOrUpdate(RankPermission rankPermission);

    void delete(Long id);
}
