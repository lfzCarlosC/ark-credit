package com.cryptal.ark.arkcreditmanager.member.page;

import cn.com.gome.cloud.openplatform.common.PageObject;
import cn.com.gome.cloud.openplatform.common.SearchFilter;
import cn.com.gome.page.button.batch.CreateOperation;
import cn.com.gome.page.button.column.DeleteOperation;
import cn.com.gome.page.button.column.EditOperation;
import cn.com.gome.page.core.PageConfig;
import cn.com.gome.page.core.PageContext;
import cn.com.gome.page.core.PageService;
import cn.com.gome.page.field.DomainLongFieldDefinition;
import cn.com.gome.page.field.LongFieldDefinition;
import com.alibaba.dubbo.config.annotation.Reference;
import com.cryptal.ark.arkcreditmanager.push.page.PushTypePageService;
import com.cryptal.ark.interfaze.member.domain.RankPermission;
import com.cryptal.ark.interfaze.member.dubbo.RankPermissionDubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RankPermissionPageService extends PageService<RankPermission,Long> {

    @Reference(group = "ark-credit-service")
    private RankPermissionDubboService rankPermissionDubboService;

    @Autowired
    private RankPageService rankPageService;

    @Autowired
    private PushTypePageService pushTypePageService;

    @Override
    public PageObject<RankPermission> paged(SearchFilter searchFilter) {
        return rankPermissionDubboService.page(searchFilter);
    }

    @Override
    protected PageConfig initializePageConfig(PageContext pageContext) {
        return new PageConfig(pageContext)
                .withDomainName("rank_permission")
                .withDomainClass(RankPermission.class)
                .withDomainChineseName("会员权限")
                .withFieldDefinitions(
                        new LongFieldDefinition("id", "ID"),
                        new DomainLongFieldDefinition("rankId", "等级", rankPageService).required(),
                        new DomainLongFieldDefinition("pushTypeId", "推送类型", pushTypePageService).required()
                )
                .withFilterDefinitions("rankId")
                .withTableColumnDefinitions(
                        "id_10",
                        "pushTypeId_50",
                        "#operation_40"
                )
                .withTableAction(
                        new CreateOperation()
                )
                .withColumnAction(
                        new DeleteOperation()
                )
                .withFormItemDefinition(
                        "rankId_rw",
                        "pushTypeId_rw"
                );
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
