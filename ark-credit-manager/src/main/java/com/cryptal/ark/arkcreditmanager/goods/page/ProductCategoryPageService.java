package com.cryptal.ark.arkcreditmanager.goods.page;

import cn.com.gome.cloud.openplatform.common.PageObject;
import cn.com.gome.cloud.openplatform.common.SearchFilter;
import cn.com.gome.page.button.batch.CreateOperation;
import cn.com.gome.page.button.column.DeleteOperation;
import cn.com.gome.page.button.column.EditOperation;
import cn.com.gome.page.category.CategoryServiceProvider;
import cn.com.gome.page.core.PageConfig;
import cn.com.gome.page.core.PageContext;
import cn.com.gome.page.core.PageService;
import cn.com.gome.page.domain.CategoryEntity;
import cn.com.gome.page.field.CategoryFieldDefinition;
import cn.com.gome.page.field.EditorFieldDefinition;
import cn.com.gome.page.field.LongFieldDefinition;
import cn.com.gome.page.field.StringFieldDefinition;
import com.alibaba.dubbo.config.annotation.Reference;
import com.cryptal.ark.interfaze.goods.domain.ProductCategory;
import com.cryptal.ark.interfaze.goods.dubbo.goods.ProductCategoryDubboService;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class ProductCategoryPageService extends PageService<ProductCategory,Long> implements CategoryServiceProvider {

    @Reference(group = "ark-credit-service")
    private ProductCategoryDubboService productCategoryDubboService;

    @Override
    public PageObject<ProductCategory> paged(SearchFilter searchFilter) {
        return productCategoryDubboService.paged(searchFilter);
    }

    @Override
    protected PageConfig initializePageConfig(PageContext pageContext) {
        PageConfig pageConfig = new PageConfig(pageContext)
                .withDomainName("product_category")
                .withDomainClass(ProductCategory.class)
                .withDomainChineseName("产品分类")
                .withFieldDefinitions(
                        new LongFieldDefinition("id", "ID"),
                        new StringFieldDefinition("name", "名字").required(),
                        new CategoryFieldDefinition("parentId", "父编码",this).required(),
                        new EditorFieldDefinition("brief", "简述")
                )
                .withFilterDefinitions("parentId")
                .withTableColumnDefinitions(
                        "id_5",
                        "name_15",
                        "brief_40",
                        "parentId_20",
                        "#operation_20"
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
                        "parentId_rw",
                        "brief_rw"
                );

        return pageConfig;
    }

    @Override
    public ProductCategory get(String id) {
        return productCategoryDubboService.get(Long.parseLong(id));
    }

    @Override
    public ProductCategory get(SearchFilter searchFilter) {
        return productCategoryDubboService.get(searchFilter);
    }

    @Override
    public CategoryEntity getCategoryEntity(String categoryId) {
        return productCategoryDubboService.get(Long.parseLong(categoryId));
    }

    @Override
    public CategoryEntity[] findAllCategoryEntity() {
        return productCategoryDubboService.findAllEnable().toArray(new CategoryEntity[0]);
    }

    @Override
    public Serializable transformToId(String fieldValue) {
        return Long.parseLong(fieldValue);
    }

    @Override
    public boolean isRoot(String categoryId) {
        return categoryId.equalsIgnoreCase("0");
    }

    @Override
    public void saveOrUpdate(ProductCategory productCategory) {
        productCategoryDubboService.saveOrUpdate(productCategory);
    }

    @Override
    public void delete(ProductCategory productCategory) {
        productCategoryDubboService.delete(productCategory.getId());
    }
}
