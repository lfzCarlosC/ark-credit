package com.cryptal.ark.arkcreditservice.goods.facade.impl;

import com.cryptal.ark.arkcreditservice.goods.entity.*;
import com.cryptal.ark.arkcreditservice.goods.facade.GoodsFacade;
import com.cryptal.ark.arkcreditservice.goods.service.*;
import com.cryptal.ark.interfaze.goods.domain.GoodsImage;
import com.cryptal.ark.interfaze.goods.request.GoodsSkuAddedRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Component
public class GoodsFacadeImpl implements GoodsFacade {

    @Autowired
    private GoodsSkuService goodsSkuService;

    @Autowired
    private ProductService productService;

    @Autowired
    private GoodsSellAttributeService goodsSellAttributeService;

    @Autowired
    private GoodsImageService goodsImageService;

    @Autowired
    private SellAttributeService sellAttributeService;

    @Autowired
    private SellAttributeValueService sellAttributeValueService;

    @Override
    public void addSku(GoodsSkuAddedRequest request) {
        GoodsSkuEntity goodsSkuEntity = persistGoodsSku(request);
        persistImages(request, goodsSkuEntity);
        persistSellAttributes(request, goodsSkuEntity);
    }

    private GoodsSkuEntity persistGoodsSku(GoodsSkuAddedRequest request) {
        String skuName = buildSkuName(request);
        GoodsSkuEntity goodsSkuEntity = new GoodsSkuEntity();
        goodsSkuEntity.setProductId(request.getProductId());
        goodsSkuEntity.setSkuName(skuName);
        goodsSkuEntity.setStock(request.getStock());
        goodsSkuEntity.setOnSale(false);
        goodsSkuEntity.setPrice(request.getPrice());
        goodsSkuEntity.setCreatedTime(new Date());
        goodsSkuEntity.setModifyTime(new Date());
        goodsSkuEntity.setGoodsNo(request.getGoodsNo());
        goodsSkuEntity.setBarCode(request.getBarCode());
        goodsSkuService.insert(goodsSkuEntity);
        return goodsSkuEntity;
    }

    private void persistSellAttributes(GoodsSkuAddedRequest request, GoodsSkuEntity goodsSkuEntity) {

        List<GoodsSellAttributeEntity> goodsSellAttributeEntities = new ArrayList<>();

        for (Map.Entry<Long, Long> attributeValueEntry : request.getAttributeValues().entrySet()) {
            GoodsSellAttributeEntity goodsSellAttributeEntity = new GoodsSellAttributeEntity();
            goodsSellAttributeEntity.setSkuId(goodsSkuEntity.getId());
            goodsSellAttributeEntity.setSellAttributeId(attributeValueEntry.getKey());
            goodsSellAttributeEntity.setSellAttributeValueId(attributeValueEntry.getValue());
            goodsSellAttributeEntities.add(goodsSellAttributeEntity);
        }
        goodsSellAttributeService.saveAll(goodsSellAttributeEntities);
    }

    private void persistImages(GoodsSkuAddedRequest request, GoodsSkuEntity goodsSkuEntity) {
        List<GoodsImageEntity> goodsImageList = new ArrayList<>();
        for (String imagePath : request.getImagePath()) {
            GoodsImageEntity goodsImageEntity = new GoodsImageEntity();
            goodsImageEntity.setSkuId(goodsSkuEntity.getId());
            goodsImageEntity.setImagePath(imagePath);
            goodsImageList.add(goodsImageEntity);
        }
        goodsImageService.insertAll(goodsImageList);
    }

    /**
     * 获取SKU名称
     * @param request
     * @return
     */
    private String buildSkuName(GoodsSkuAddedRequest request) {
        ProductEntity productEntity = productService.checkAndGet(request.getProductId());
        StringBuilder skuNameBuilder = new StringBuilder(productEntity.getName()).append(" ");
        for (Map.Entry<Long, Long> attributeValueEntry : request.getAttributeValues().entrySet()) {
            SellAttributeValueEntity sellAttributeValueEntity = sellAttributeValueService.checkAndGet(attributeValueEntry.getValue());
            skuNameBuilder.append(sellAttributeValueEntity.getAttributeValue()).append(" ");
        }
        return skuNameBuilder.toString();
    }

}
