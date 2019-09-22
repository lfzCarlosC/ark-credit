package com.cryptal.ark.arkcreditmanager.goods.page;

import cn.com.gome.cloud.openplatform.common.PageObject;
import cn.com.gome.cloud.openplatform.common.SearchFilter;
import cn.com.gome.page.button.batch.CreateOperation;
import cn.com.gome.page.button.column.DeleteOperation;
import cn.com.gome.page.button.column.EditOperation;
import cn.com.gome.page.button.column.EnableOperation;
import cn.com.gome.page.button.column.NewPageOperation;
import cn.com.gome.page.core.PageConfig;
import cn.com.gome.page.core.PageContext;
import cn.com.gome.page.core.PageService;
import cn.com.gome.page.field.*;
import com.alibaba.dubbo.config.annotation.Reference;
import com.cryptal.ark.interfaze.goods.domain.GoodsSku;
import com.cryptal.ark.interfaze.goods.dubbo.goods.GoodsSkuDubboService;
import org.springframework.stereotype.Component;

@Component
public class GoodsSkuPageService  extends PageService<GoodsSku,Long> {

    @Reference(group = "ark-credit-service")
    private GoodsSkuDubboService goodsSkuDubboService;

    @Override
    public PageObject<GoodsSku> paged(SearchFilter searchFilter) {
        return goodsSkuDubboService.paged(searchFilter);
    }

    @Override
    protected PageConfig initializePageConfig(PageContext pageContext) {
        return new PageConfig(pageContext)
                .withDomainName("goods_sku")
                .withDomainClass(GoodsSku.class)
                .withDomainChineseName("接口")
                .withFieldDefinitions(
                        new LongFieldDefinition("id", "ID"),
                        new DisplayStringFieldDefinition("skuName", "名称").required(),
                        new LongFieldDefinition("productId", "产品id").required(),
                        new LongFieldDefinition("stock", "库存").required(),
                        new EnableFieldDefinition("onSale", "是否上架").required(),
                        new DateFieldDefinition("createdTime", "创建时间").required(),
                        new DateFieldDefinition("modifyTime", "修改时间").required(),
                        new StringFieldDefinition("price", "价格").required()
                )
                .withTableColumnDefinitions(
                        "id_5",
                        "skuName_25",
                        "stock_10",
                        "onSale_10",
                        "price_10",
                        "createdTime_10",
                        "modifyTime_10",
                        "#operation_20"
                )
                .withTableAction(
                        new CreateOperation()
                )
                .withColumnAction(
                        new NewPageOperation("主图设置","/admin/goods_image/page?skuId=#id#","主图设置","id"),
                        new NewPageOperation("销售属性设置","/admin/goods_sell_attribute/page?skuId=#id#","销售属性设置","id"),
                        new EnableOperation("onSale"),
                        new EditOperation(),
                        new DeleteOperation()
                )
                .withFormItemDefinition(
                        "price_rw",
                        "stock_rw",
                        "onSale_rw"
                );
    }

    @Override
    public GoodsSku get(String id) {
        return goodsSkuDubboService.get(Long.parseLong(id));
    }

    @Override
    public GoodsSku get(SearchFilter searchFilter) {
        return goodsSkuDubboService.get(searchFilter);
    }

    @Override
    public void saveOrUpdate(GoodsSku goodsSku) {
        goodsSkuDubboService.saveOrUpdate(goodsSku);
    }

    @Override
    public void delete(GoodsSku goodsSku) {
        goodsSkuDubboService.delete(goodsSku.getId());
    }
}
