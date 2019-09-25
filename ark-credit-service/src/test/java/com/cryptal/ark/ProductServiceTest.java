package com.cryptal.ark;

import com.cryptal.ark.arkcreditservice.goods.request.GoodsSkuAddedRequest;
import com.cryptal.ark.arkcreditservice.goods.service.GoodsSkuService;
import com.cryptal.ark.arkcreditservice.goods.service.impl.GoodsSkuServiceImpl;

import static org.junit.Assert.*;

public class ProductServiceTest {


    private GoodsSkuService goodsSkuService = new GoodsSkuServiceImpl();

    /**
     * 用例：创建商品
     */
    public void test_create_goods(){

        GoodsSkuAddedRequest request = new GoodsSkuAddedRequest();
        request.setPrice("10");
        request.setProductId(10L);
        request.setStock(10L);
        goodsSkuService.addSku(request);
    }

}