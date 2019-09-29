package com.cryptal.ark.arkcreditservice.goods;

import com.cryptal.ark.arkcreditservice.goods.entity.*;
import com.cryptal.ark.arkcreditservice.goods.service.*;
import com.cryptal.ark.arkcreditservice.goods.service.impl.*;

import java.util.List;

public class GoodsServiceTest {

    private ProductCategoryService productCategoryService = new ProductCategoryServiceImpl();

    private ProductService productService = new ProductServiceImpl();

    private GoodsSellAttributeService goodsSellAttributeService = new GoodsSellAttributeServiceImpl();

    private GoodsImageService goodsImageService = new GoodsImageServiceImpl();

    private GoodsSkuService goodsSkuService = new GoodsSkuServiceImpl();

    private SellAttributeService sellAttributeService = new SellAttributeServiceImpl();

    private SellAttributeValueService sellAttributeValueService = new SellAttributeValueServiceImpl();

    /**
     * 用例：展示商品的详细信息，SKU信息（价格，库存，是否上架，主图），Goods信息（名字）
     */
    public void test_detail_goods(){

        Long skuId= 1L;

        //SKU
        GoodsSkuEntity goodsSkuEntity = goodsSkuService.get(skuId);

        //商品
        ProductEntity productEntity = productService.get(goodsSkuEntity.getProductId());

        //图片
        List<GoodsImageEntity> goodsImageEntities = goodsImageService.findBySkuId(skuId);


        //所有的销售属性 + 所有的销售属性值
        List<SellAttributeEntity> sellAttributeEntities =  sellAttributeService.findByCategoryId(productEntity.getCategoryId());

        for (SellAttributeEntity sellAttributeEntity : sellAttributeEntities) {

            //选中的销售属性值
            SellAttributeValueEntity sellAttributeValueEntity = goodsSellAttributeService.findBySkuAndSellAttributeId(skuId, sellAttributeEntity.getId());

            //销售属性值列表
            List<SellAttributeValueEntity> sellAttributeValueEntities = sellAttributeValueService.findByAttributeId(sellAttributeEntity.getId());


        }


    }


}
