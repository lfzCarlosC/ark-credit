package com.cryptal.ark.arkcreditmanager.goods.page;

import cn.com.gome.cloud.openplatform.common.PageObject;
import cn.com.gome.cloud.openplatform.common.SearchFilter;
import cn.com.gome.page.button.batch.CreateOperation;
import cn.com.gome.page.button.column.DeleteOperation;
import cn.com.gome.page.button.column.EditOperation;
import cn.com.gome.page.core.PageConfig;
import cn.com.gome.page.core.PageContext;
import cn.com.gome.page.core.PageService;
import cn.com.gome.page.field.DomainLongFieldDefinition;
import cn.com.gome.page.field.LinkInFieldDefinition;
import cn.com.gome.page.field.LongFieldDefinition;
import cn.com.gome.page.field.StringFieldDefinition;
import cn.com.gome.page.field.validator.IntFieldDefinition;
import com.alibaba.dubbo.config.annotation.Reference;
import com.cryptal.ark.interfaze.goods.domain.SellAttributeValue;
import com.cryptal.ark.interfaze.goods.dubbo.goods.SellAttributeValueDubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SellAttributeValuePageService extends PageService<SellAttributeValue,Long>{

    @Reference(group = "ark-credit-service")
    private SellAttributeValueDubboService sellAttributeValueDubboService;

    @Autowired
    private SellAttributePageService sellAttributePageService;

    @Autowired
    private ProductCategoryPageService productCategoryPageService;

    @Override
    public PageObject<SellAttributeValue> paged(SearchFilter searchFilter) {
        return sellAttributeValueDubboService.page(searchFilter);
    }

    @Override
    protected PageConfig initializePageConfig(PageContext pageContext) {
        return new PageConfig(pageContext)
                .withDomainName("sell_attribute_value")
                .withDomainClass(SellAttributeValue.class)
                .withDomainChineseName("销售属性值")
                .withFieldDefinitions(
                        new LongFieldDefinition("id", "ID"),
                        new DomainLongFieldDefinition("categoryId", "分类",productCategoryPageService).required(),
                        new LinkInFieldDefinition("attributeId", "销售属性",sellAttributePageService).required(),
                        new IntFieldDefinition("sortNum", "排序号").required(),
                        new StringFieldDefinition("attributeValue", "销售属性值").required()
                )
                .withTableColumnDefinitions(
                        "id_10",
                        "attributeValue_20",
                        "categoryId_15",
                        "sortNum_15",
                        "attributeId_20",
                        "#operation_20"
                )
                .withFilterDefinitions("attributeId")
                .withTableAction(
                        new CreateOperation()
                )
                .withColumnAction(
                        new EditOperation(),
                        new DeleteOperation()
                )
                .withFormItemDefinition(
                        "categoryId_h",
                        "attributeId_rw",
                        "attributeValue_rw",
                        "sortNum_rw"
                );
    }

    @Override
    public SellAttributeValue get(String id) {
        return sellAttributeValueDubboService.get(Long.parseLong(id));
    }

    @Override
    public SellAttributeValue get(SearchFilter searchFilter) {
        return sellAttributeValueDubboService.get(searchFilter);
    }

    @Override
    public void saveOrUpdate(SellAttributeValue sellAttributeValue) {
        sellAttributeValueDubboService.saveOrUpdate(sellAttributeValue);
    }

    @Override
    public void delete(SellAttributeValue sellAttributeValue) {
        sellAttributeValueDubboService.delete(sellAttributeValue.getId());
    }
}
