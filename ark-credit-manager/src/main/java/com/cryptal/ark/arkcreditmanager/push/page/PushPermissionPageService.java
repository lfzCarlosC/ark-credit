package com.cryptal.ark.arkcreditmanager.push.page;

import cn.com.gome.cloud.openplatform.common.PageObject;
import cn.com.gome.cloud.openplatform.common.SearchFilter;
import cn.com.gome.page.button.batch.CreateOperation;
import cn.com.gome.page.button.column.DeleteOperation;
import cn.com.gome.page.button.column.EditOperation;
import cn.com.gome.page.button.column.NewPageOperation;
import cn.com.gome.page.core.PageConfig;
import cn.com.gome.page.core.PageContext;
import cn.com.gome.page.core.PageService;
import cn.com.gome.page.field.CategoryFieldDefinition;
import cn.com.gome.page.field.DisplayStringFieldDefinition;
import cn.com.gome.page.field.LongFieldDefinition;
import cn.com.gome.page.field.StringFieldDefinition;
import com.alibaba.dubbo.config.annotation.Reference;
import com.cryptal.ark.interfaze.goods.domain.SellAttribute;
import com.cryptal.ark.interfaze.push.domain.PushPermission;
import com.cryptal.ark.interfaze.push.dubbo.PushPermissionDubboService;
import org.springframework.stereotype.Component;

@Component
public class PushPermissionPageService extends PageService<PushPermission,Long> {

    @Reference(group = "ark-credit-service")
    private PushPermissionDubboService pushPermissionDubboService;

    @Override
    public PageObject<PushPermission> paged(SearchFilter searchFilter) {
        return pushPermissionDubboService.page(searchFilter);
    }

    @Override
    protected PageConfig initializePageConfig(PageContext pageContext) {
        PageConfig pageConfig = new PageConfig(pageContext)
                .withDomainName("push_permission")
                .withDomainClass(PushPermission.class)
                .withDomainChineseName("权限")
                .withFieldDefinitions(
                        new LongFieldDefinition("id", "ID"),
                        new StringFieldDefinition("name", "名称").required(),
                        new StringFieldDefinition("identifier", "唯一标识").required()
                )
                .withTableColumnDefinitions(
                        "id_10",
                        "name_30",
                        "identifier_20",
                        "#operation_40"
                )
                .withTableAction(
                        new CreateOperation()
                )
                .withColumnAction(
                        new EditOperation(),
                        new DeleteOperation()
                )
                .withFormItemDefinition(
                        "name_rw",
                        "identifier_rw"
                );
        return pageConfig;
    }

    @Override
    public PushPermission get(String id) {
        return pushPermissionDubboService.get(Long.parseLong(id));
    }

    @Override
    public PushPermission get(SearchFilter searchFilter) {
        return pushPermissionDubboService.get(searchFilter);
    }

    @Override
    public void saveOrUpdate(PushPermission pushPermission) {
        pushPermissionDubboService.saveOrUpdate(pushPermission);
    }

    @Override
    public void delete(PushPermission pushPermission) {
        pushPermissionDubboService.delete(pushPermission.getId());
    }
}
