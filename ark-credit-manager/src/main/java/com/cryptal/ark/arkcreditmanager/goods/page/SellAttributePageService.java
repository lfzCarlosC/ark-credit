package com.cryptal.ark.arkcreditmanager.goods.page;

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
import cn.com.gome.page.field.domain.LinkInObject;
import cn.com.gome.page.field.linkin.LinkInDomain;
import cn.com.gome.page.field.linkin.LinkInProvider;
import com.alibaba.dubbo.config.annotation.Reference;
import com.cryptal.ark.interfaze.goods.domain.ProductCategory;
import com.cryptal.ark.interfaze.goods.domain.SellAttribute;
import com.cryptal.ark.interfaze.goods.dubbo.goods.ProductCategoryDubboService;
import com.cryptal.ark.interfaze.goods.dubbo.goods.SellAttributeDubboService;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SellAttributePageService extends PageService<SellAttribute,Long> implements LinkInProvider {

    @Reference(group = "ark-credit-service")
    private SellAttributeDubboService sellAttributeDubboService;

    @Autowired
    private ProductCategoryPageService productCategoryPageService;

    @Reference(group = "ark-credit-service")
    private ProductCategoryDubboService productCategoryDubboService;

    private Gson gson = new GsonBuilder().create();

    @Override
    public PageObject<SellAttribute> paged(SearchFilter searchFilter) {
        return sellAttributeDubboService.page(searchFilter);
    }

    @Override
    protected PageConfig initializePageConfig(PageContext pageContext) {
        PageConfig pageConfig = new PageConfig(pageContext)
                .withDomainName("sell_attribute")
                .withDomainClass(SellAttribute.class)
                .withDomainChineseName("销售属性")
                .withFieldDefinitions(
                        new LongFieldDefinition("id", "ID"),
                        new DisplayStringFieldDefinition("name", "名称").required(),
                        new CategoryFieldDefinition("categoryId", "分类",productCategoryPageService).required()
                )
                .withTableColumnDefinitions(
                        "id_10",
                        "name_30",
                        "categoryId_20",
                        "#operation_40"
                )
                .withFilterDefinitions("categoryId")
                .withTableAction(
                        new CreateOperation()
                )
                .withColumnAction(
                        new NewPageOperation("销售属性值","/admin/sell_attribute_value/page?categoryId=#categoryId#&attributeId=#id#","销售属性值","categoryId","id"),
                        new EditOperation(),
                        new DeleteOperation()
                )
                .withFormItemDefinition(
                        "name_rw",
                        "categoryId_rw"
                );
        return pageConfig;
    }

    @Override
    public SellAttribute get(String id) {
        return sellAttributeDubboService.get(Long.parseLong(id));
    }

    @Override
    public SellAttribute get(SearchFilter searchFilter) {
        return sellAttributeDubboService.get(searchFilter);
    }

    @Override
    public void saveOrUpdate(SellAttribute sellAttribute) {
        sellAttributeDubboService.saveOrUpdate(sellAttribute);
    }

    @Override
    public void delete(SellAttribute sellAttribute) {
        sellAttributeDubboService.delete(sellAttribute.getId());
    }

    @Override
    public String obtainSelectJson() {
        List<LinkInObject> linkInObjects = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryDubboService.findAllEnable()) {
            List<LinkInObject> linkInObjects2 = new ArrayList<>();
            for (SellAttribute sellAttribute : sellAttributeDubboService.findByCategoryId(productCategory.getId())) {
                linkInObjects2.add(new LinkInObject(sellAttribute.getId(),sellAttribute.getName()));
            }
            LinkInObject linkInObject = new LinkInObject(productCategory.getId(), productCategory.getName());
            linkInObject.setSub(linkInObjects2);
            linkInObjects.add(linkInObject);
        }
        return gson.toJson(linkInObjects);
    }

    @Override
    public List<LinkInDomain> buildLinkInConfigs() {
        return Lists.newArrayList(
                new LinkInDomain("categoryId","分类"),
                new LinkInDomain("attributeId","销售属性")
        );
    }

    @Override
    public SellAttribute findByReferId(String referId) {
        return sellAttributeDubboService.get(Long.parseLong(referId));
    }

    @Override
    public String getDomainName() {
        return "sell_attribute";
    }

    @Override
    public String getDomainChineseName() {
        return "销售属性";
    }

    @Override
    public String getDisplayFieldName() {
        return "name";
    }

    @Override
    public List findAll() {
        return sellAttributeDubboService.findAll();
    }
}
