package com.cryptal.ark.arkcreditmanager.push.page;

import cn.com.gome.cloud.openplatform.common.PageObject;
import cn.com.gome.cloud.openplatform.common.SearchFilter;
import cn.com.gome.page.button.batch.CreateOperation;
import cn.com.gome.page.button.column.DeleteOperation;
import cn.com.gome.page.button.column.EditOperation;
import cn.com.gome.page.core.PageConfig;
import cn.com.gome.page.core.PageContext;
import cn.com.gome.page.core.PageService;
import cn.com.gome.page.field.LongFieldDefinition;
import cn.com.gome.page.field.StringFieldDefinition;
import cn.com.gome.page.field.domain.PageDomainProvider;
import com.alibaba.dubbo.config.annotation.Reference;
import com.cryptal.ark.interfaze.member.domain.Rank;
import com.cryptal.ark.interfaze.push.domain.PushType;
import com.cryptal.ark.interfaze.push.dubbo.PushTypeDubboService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PushTypePageService extends PageService<PushType,Long> implements PageDomainProvider<PushType> {

    @Reference(group = "ark-credit-service")
    private PushTypeDubboService pushTypeDubboService;

    @Override
    public PageObject<PushType> paged(SearchFilter searchFilter) {
        return pushTypeDubboService.page(searchFilter);
    }

    @Override
    protected PageConfig initializePageConfig(PageContext pageContext) {
        PageConfig pageConfig = new PageConfig(pageContext)
                .withDomainName("push_type")
                .withDomainClass(PushType.class)
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
    public PushType get(String id) {
        return pushTypeDubboService.get(Long.parseLong(id));
    }

    @Override
    public PushType get(SearchFilter searchFilter) {
        return pushTypeDubboService.get(searchFilter);
    }

    @Override
    public void saveOrUpdate(PushType pushType) {
        pushTypeDubboService.saveOrUpdate(pushType);
    }

    @Override
    public void delete(PushType pushType) {
        pushTypeDubboService.delete(pushType.getId());
    }

    @Override
    public Object findByReferId(String referId) {
        return pushTypeDubboService.get(Long.parseLong(referId));
    }

    @Override
    public String getDomainName() {
        return "推送类别";
    }

    @Override
    public String getDomainChineseName() {
        return "推送类别";
    }

    @Override
    public String getDisplayFieldName() {
        return "name";
    }

    @Override
    public List<PushType> findAll() {
        return pushTypeDubboService.findAll();
    }
}
