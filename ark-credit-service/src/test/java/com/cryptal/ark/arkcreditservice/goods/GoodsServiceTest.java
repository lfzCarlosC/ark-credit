package com.cryptal.ark.arkcreditservice.goods;

import com.cryptal.ark.arkcreditservice.goods.entity.*;
import com.cryptal.ark.arkcreditservice.goods.service.*;
import com.cryptal.ark.arkcreditservice.goods.service.impl.*;

import java.math.BigDecimal;
import java.util.List;

public class GoodsServiceTest {

    private ProductCategoryService productCategoryService = new ProductCategoryServiceImpl();

    private GoodsService goodsService = new GoodsServiceImpl();

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
        GoodsSkuEntity goodsSkuEntity = goodsSkuService.findById(skuId);

        //商品
        ProductEntity productEntity = goodsService.findById(goodsSkuEntity.getGoodsId());

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


    /**
     * 用例：初始化会员等级商品
     */
    public void test_add_rank_goods_type(){

        //初始化销售属性值分类
        ProductCategoryEntity productCategoryEntity = new ProductCategoryEntity();
        productCategoryEntity.setId(1L);
        productCategoryEntity.setName("会员等级商品");
        productCategoryService.insert(productCategoryEntity);

        //增加销售属性值
        SellAttributeEntity sellAttributeEntity1 = new SellAttributeEntity();
        sellAttributeEntity1.setId(1L);
        sellAttributeEntity1.setCategoryId(1L);
        sellAttributeEntity1.setName("等级");
        sellAttributeService.insert(sellAttributeEntity1);

        SellAttributeEntity sellAttributeEntity2 = new SellAttributeEntity();
        sellAttributeEntity2.setId(1L);
        sellAttributeEntity2.setCategoryId(1L);
        sellAttributeEntity2.setName("有效期");
        sellAttributeService.insert(sellAttributeEntity2);

        SellAttributeValueEntity sellAttributeValueEntity1 = new SellAttributeValueEntity();
        sellAttributeValueEntity1.setId(1L);
        sellAttributeValueEntity1.setAttributeId(1L);
        sellAttributeValueEntity1.setAttributeValue("黄金会员");
        sellAttributeValueService.save(sellAttributeValueEntity1);

        SellAttributeValueEntity sellAttributeValueEntity2 = new SellAttributeValueEntity();
        sellAttributeValueEntity2.setId(2L);
        sellAttributeValueEntity2.setAttributeId(1L);
        sellAttributeValueEntity2.setAttributeValue("钻石会员");
        sellAttributeValueService.save(sellAttributeValueEntity2);

        SellAttributeValueEntity sellAttributeValueEntity3 = new SellAttributeValueEntity();
        sellAttributeValueEntity2.setId(2L);
        sellAttributeValueEntity2.setAttributeId(2L);
        sellAttributeValueEntity2.setAttributeValue("一年");
        sellAttributeValueService.save(sellAttributeValueEntity2);

        SellAttributeValueEntity sellAttributeValueEntity4 = new SellAttributeValueEntity();
        sellAttributeValueEntity4.setId(2L);
        sellAttributeValueEntity4.setAttributeId(2L);
        sellAttributeValueEntity4.setAttributeValue("一个月");
        sellAttributeValueService.save(sellAttributeValueEntity2);

        //商品
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(1L);
        productEntity.setName("会员等级购买");
        productEntity.setCategoryId(1L);
        goodsService.save(productEntity);


        //sku
        GoodsSkuEntity goodsSkuEntity = new GoodsSkuEntity();
        goodsSkuEntity.setGoodsId(1L);
        goodsSkuEntity.setOnSale(false);
        goodsSkuEntity.setStock(99L);
        goodsSkuEntity.setPrice(new BigDecimal(10.00));

        //图片
        GoodsImageEntity goodsImageEntity = new GoodsImageEntity();
        goodsImageEntity.setSkuId(goodsSkuEntity.getId());
        goodsImageEntity.setImagePath("");
        goodsImageService.save(goodsImageEntity);

        //商品销售属性
        GoodsSellAttributeEntity goodsSellAttributeEntity1 = new GoodsSellAttributeEntity();
        goodsSellAttributeEntity1.setSkuId(goodsSkuEntity.getId());
        goodsSellAttributeEntity1.setSellAttributeId(1L);
        goodsSellAttributeEntity1.setSellAttributeValueId(1L);
        goodsSellAttributeService.save(goodsSellAttributeEntity1);


        GoodsSellAttributeEntity goodsSellAttributeEntity2 = new GoodsSellAttributeEntity();
        goodsSellAttributeEntity2.setSkuId(goodsSkuEntity.getId());
        goodsSellAttributeEntity2.setSellAttributeId(2L);
        goodsSellAttributeEntity2.setSellAttributeValueId(3L);
        goodsSellAttributeService.save(goodsSellAttributeEntity2);
    }

}
