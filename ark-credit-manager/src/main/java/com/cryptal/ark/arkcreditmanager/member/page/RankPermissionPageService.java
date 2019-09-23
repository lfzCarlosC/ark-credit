package com.cryptal.ark.arkcreditmanager.member.page;

import cn.com.gome.cloud.openplatform.common.PageObject;
import cn.com.gome.cloud.openplatform.common.SearchFilter;
import cn.com.gome.page.core.PageConfig;
import cn.com.gome.page.core.PageContext;
import cn.com.gome.page.core.PageService;
import com.alibaba.dubbo.config.annotation.Reference;
import com.cryptal.ark.interfaze.member.domain.RankPermission;
import com.cryptal.ark.interfaze.member.dubbo.RankPermissionDubboService;
import org.springframework.stereotype.Component;

@Component
public class RankPermissionPageService extends PageService<RankPermission,Long> {

    @Reference(group = "ark-credit-service")
    private RankPermissionDubboService rankPermissionDubboService;

    @Override
    public PageObject<RankPermission> paged(SearchFilter searchFilter) {
        return rankPermissionDubboService.page(searchFilter);
    }

    @Override
    protected PageConfig initializePageConfig(PageContext pageContext) {
        return null;
    }

    @Override
    public RankPermission get(String id) {
        return rankPermissionDubboService.get(Long.parseLong(id));
    }

    @Override
    public RankPermission get(SearchFilter searchFilter) {
        return rankPermissionDubboService.get(searchFilter);
    }

    @Override
    public void saveOrUpdate(RankPermission rankPermission) {
        rankPermissionDubboService.saveOrUpdate(rankPermission);
    }

    @Override
    public void delete(RankPermission rankPermission) {
        rankPermissionDubboService.delete(rankPermission.getId());
    }
}
