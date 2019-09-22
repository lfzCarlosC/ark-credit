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
import cn.com.gome.page.field.*;
import com.alibaba.dubbo.config.annotation.Reference;
import com.cryptal.ark.interfaze.goods.domain.Product;
import com.cryptal.ark.interfaze.goods.dubbo.goods.ProductDubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductPageService  extends PageService<Product,Long> {

    @Reference(group = "ark-credit-service")
    private ProductDubboService productDubboService;

    @Autowired
    private ProductCategoryPageService productCategoryPageService;

    @Override
    public PageObject<Product> paged(SearchFilter searchFilter) {
        return productDubboService.paged(searchFilter);
    }

    @Override
    protected PageConfig initializePageConfig(PageContext pageContext) {
        return new PageConfig(pageContext)
                .withDomainName("product")
                .withDomainClass(Product.class)
                .withDomainChineseName("产品")
                .withFieldDefinitions(
                        new LongFieldDefinition("id", "ID"),
                        new DisplayStringFieldDefinition("name", "名称").required(),
                        new CategoryFieldDefinition("categoryId", "分类",productCategoryPageService).required(),
                        new EditorFieldDefinition("content", "描述").required(),
                        new DateFieldDefinition("createdTime", "创建时间").required(),
                        new DateFieldDefinition("modifyTime", "修改时间").required()

                )
                .withTableColumnDefinitions(
                        "id_10",
                        "name_30",
                        "categoryId_20",
                        "createdTime_10",
                        "modifyTime_10",
                        "#operation_20"
                )
                .withFilterDefinitions("categoryId")
                .withTableAction(
                        new CreateOperation()
                )
                .withColumnAction(
                        new NewPageOperation("SKU设置","/admin/goods_sku/page?productId=#id#","SKU设置","id"),
                        new EditOperation(),
                        new DeleteOperation()
                )
                .withFormItemDefinition(
                        "name_rw",
                        "categoryId_rw",
                        "content_rw"
                );
    }

    @Override
    public Product get(String id) {
        return productDubboService.get(Long.parseLong(id));
    }

    @Override
    public Product get(SearchFilter searchFilter) {
        return productDubboService.get(searchFilter);
    }

    @Override
    public void saveOrUpdate(Product product) {
        productDubboService.saveOrUpdate(product);
    }

    @Override
    public void delete(Product product) {
        productDubboService.delete(product.getId());
    }
}
