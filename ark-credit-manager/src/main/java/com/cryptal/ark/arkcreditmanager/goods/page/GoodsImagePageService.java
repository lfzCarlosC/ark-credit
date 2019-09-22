package com.cryptal.ark.arkcreditmanager.goods.page;

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
import com.alibaba.dubbo.config.annotation.Reference;
import com.cryptal.ark.interfaze.goods.domain.GoodsImage;
import com.cryptal.ark.interfaze.goods.dubbo.goods.GoodsImageDubboService;
import org.springframework.stereotype.Component;

@Component
public class GoodsImagePageService  extends PageService<GoodsImage,Long> {

    @Reference(group = "ark-credit-service")
    private GoodsImageDubboService goodsImageDubboService;

    @Override
    public PageObject<GoodsImage> paged(SearchFilter searchFilter) {
        return goodsImageDubboService.paged(searchFilter);
    }

    @Override
    protected PageConfig initializePageConfig(PageContext pageContext) {
        return new PageConfig(pageContext)
                .withDomainName("goods_image")
                .withDomainClass(GoodsImage.class)
                .withDomainChineseName("商品图片")
                .withFieldDefinitions(
                        new LongFieldDefinition("id", "ID"),
                        new LongFieldDefinition("skuId", "SKU").required(),
                        new StringFieldDefinition("imagePath", "图片地址").required()
                )
                .withTableColumnDefinitions(
                        "id_10",
                        "skuId_20",
                        "imagePath_40",
                        "#operation_30"
                )
                .withTableAction(
                        new CreateOperation()
                )
                .withColumnAction(
                        new EditOperation(),
                        new DeleteOperation()
                )
                .withFormItemDefinition(
                        "imagePath_rw"
                );

    }

    @Override
    public GoodsImage get(String id) {
        return goodsImageDubboService.get(Long.parseLong(id));
    }

    @Override
    public GoodsImage get(SearchFilter searchFilter) {
        return goodsImageDubboService.get(searchFilter);
    }

    @Override
    public void saveOrUpdate(GoodsImage goodsImage) {
        goodsImageDubboService.saveOrUpdate(goodsImage);
    }

    @Override
    public void delete(GoodsImage goodsImage) {
        goodsImageDubboService.delete(goodsImage.getId());
    }

}
