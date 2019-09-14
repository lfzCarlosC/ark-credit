package com.cryptal.ark.arkcreditservice.goods;

import com.cryptal.ark.arkcreditservice.goods.domain.*;
import com.cryptal.ark.arkcreditservice.goods.service.*;
import com.cryptal.ark.arkcreditservice.goods.service.impl.*;

import java.math.BigDecimal;
import java.util.List;

public class GoodsServiceTest {

    private GoodsCategoryService goodsCategoryService = new GoodsCategoryServiceImpl();

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
        GoodsSku goodsSku = goodsSkuService.findById(skuId);

        //商品
        Goods goods = goodsService.findById(goodsSku.getGoodsId());

        //图片
        List<GoodsImage> goodsImages = goodsImageService.findBySkuId(skuId);


        //所有的销售属性 + 所有的销售属性值
        List<SellAttribute> sellAttributes =  sellAttributeService.findByCategoryId(goods.getCategoryId());

        for (SellAttribute sellAttribute : sellAttributes) {

            //选中的销售属性值
            SellAttributeValue sellAttributeValue = goodsSellAttributeService.findBySkuAndSellAttributeId(skuId,sellAttribute.getId());

            //销售属性值列表
            List<SellAttributeValue> sellAttributeValues = sellAttributeValueService.findByAttributeId(sellAttribute.getId());


        }


    }


    /**
     * 用例：初始化会员等级商品
     */
    public void test_add_rank_goods_type(){

        //初始化销售属性值分类
        GoodsCategory goodsCategory = new GoodsCategory();
        goodsCategory.setId(1L);
        goodsCategory.setName("会员等级商品");
        goodsCategoryService.save(goodsCategory);

        //增加销售属性值
        SellAttribute sellAttribute1 = new SellAttribute();
        sellAttribute1.setId(1L);
        sellAttribute1.setSellCategoryId(1L);
        sellAttribute1.setName("等级");
        sellAttributeService.save(sellAttribute1);

        SellAttribute sellAttribute2 = new SellAttribute();
        sellAttribute2.setId(1L);
        sellAttribute2.setSellCategoryId(1L);
        sellAttribute2.setName("有效期");
        sellAttributeService.save(sellAttribute2);

        SellAttributeValue sellAttributeValue1 = new SellAttributeValue();
        sellAttributeValue1.setId(1L);
        sellAttributeValue1.setAttributeId(1L);
        sellAttributeValue1.setAttributeValue("黄金会员");
        sellAttributeValueService.save(sellAttributeValue1);

        SellAttributeValue sellAttributeValue2 = new SellAttributeValue();
        sellAttributeValue2.setId(2L);
        sellAttributeValue2.setAttributeId(1L);
        sellAttributeValue2.setAttributeValue("钻石会员");
        sellAttributeValueService.save(sellAttributeValue2);

        SellAttributeValue sellAttributeValue3 = new SellAttributeValue();
        sellAttributeValue2.setId(2L);
        sellAttributeValue2.setAttributeId(2L);
        sellAttributeValue2.setAttributeValue("一年");
        sellAttributeValueService.save(sellAttributeValue2);

        SellAttributeValue sellAttributeValue4 = new SellAttributeValue();
        sellAttributeValue4.setId(2L);
        sellAttributeValue4.setAttributeId(2L);
        sellAttributeValue4.setAttributeValue("一个月");
        sellAttributeValueService.save(sellAttributeValue2);

        //商品
        Goods goods = new Goods();
        goods.setId(1L);
        goods.setGoodsName("会员等级购买");
        goods.setCategoryId(1L);
        goodsService.save(goods);


        //sku
        GoodsSku goodsSku = new GoodsSku();
        goodsSku.setGoodsId(1L);
        goodsSku.setOnSale(false);
        goodsSku.setStock(99L);
        goodsSku.setPrice(new BigDecimal(10.00));

        //图片
        GoodsImage goodsImage = new GoodsImage();
        goodsImage.setSkuId(goodsSku.getId());
        goodsImage.setImagePath("");
        goodsImageService.save(goodsImage);

        //商品销售属性
        GoodsSellAttribute goodsSellAttribute1 = new GoodsSellAttribute();
        goodsSellAttribute1.setSkuId(goodsSku.getId());
        goodsSellAttribute1.setSellAttributeId(1L);
        goodsSellAttribute1.setSellAttributeValueId(1L);
        goodsSellAttributeService.save(goodsSellAttribute1);


        GoodsSellAttribute goodsSellAttribute2 = new GoodsSellAttribute();
        goodsSellAttribute2.setSkuId(goodsSku.getId());
        goodsSellAttribute2.setSellAttributeId(2L);
        goodsSellAttribute2.setSellAttributeValueId(3L);
        goodsSellAttributeService.save(goodsSellAttribute2);
    }

}
