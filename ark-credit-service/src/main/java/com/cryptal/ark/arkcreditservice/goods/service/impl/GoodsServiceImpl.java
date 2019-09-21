package com.cryptal.ark.arkcreditservice.goods.service.impl;

import com.cryptal.ark.arkcreditservice.common.exp.CreditException;
import com.cryptal.ark.arkcreditservice.goods.dao.ProductDao;
import com.cryptal.ark.arkcreditservice.goods.dao.GoodsSellAttributeDao;
import com.cryptal.ark.arkcreditservice.goods.dao.GoodsSkuDao;
import com.cryptal.ark.arkcreditservice.goods.dao.SellAttributeValueDao;
import com.cryptal.ark.arkcreditservice.goods.entity.ProductEntity;
import com.cryptal.ark.arkcreditservice.goods.entity.GoodsSkuEntity;
import com.cryptal.ark.arkcreditservice.goods.service.GoodsService;
import com.cryptal.ark.arkcreditservice.member.event.MemberRankOrdered;
import com.cryptal.ark.arkcreditservice.order.event.OrderCreated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private ApplicationEventPublisher publisher;

    @Autowired
    private GoodsExecutors goodsExecutors;

    @Autowired
    private GoodsSkuDao goodsSkuDao;

    @Autowired
    private GoodsSellAttributeDao goodsSellAttributeDao;

    @Autowired
    private SellAttributeValueDao sellAttributeValueDao;

    @Autowired
    private ProductDao productDao;

    @Override
    public void handleOrderCreated(OrderCreated event) {

        GoodsSkuEntity goodsSkuEntity = checkAndFind(event.getSkuId());

        goodsSkuEntity.setStock(goodsSkuEntity.getStock()-event.getCount());
        goodsSkuDao.save(goodsSkuEntity);

        //如何获得购买的是等级商品，获取等级（黄金会员），获取时长（一个月），发送会员被购买事件

        ProductEntity productEntity = checkAndFind(goodsSkuEntity);

        if(checkIsRankGoods(productEntity)){
            publisher.publishEvent(new MemberRankOrdered(this,event.getSkuId(),event.getUserId()));
        }

    }

    /**
     * 校验商品是等级商品
     * @param productEntity
     * @return
     */
    private boolean checkIsRankGoods(ProductEntity productEntity) {
        return false;
    }


    private ProductEntity checkAndFind(GoodsSkuEntity goodsSkuEntity) {
        Optional<ProductEntity> goodsOptional = productDao.findById(goodsSkuEntity.getGoodsId());
        if(!goodsOptional.isPresent()){
            throw new CreditException("商品信息不存在：" + goodsSkuEntity.getGoodsId());
        }
        return goodsOptional.get();
    }

    private GoodsSkuEntity checkAndFind(Long skuId) {
        Optional<GoodsSkuEntity> goodsSkuOptional = goodsSkuDao.findById(skuId);
        if(!goodsSkuOptional.isPresent()){
            throw new CreditException("商品SKU信息不存在" + skuId);
        }

        return goodsSkuOptional.get();
    }

    @Override
    public ProductEntity findById(Long id) {
        return null;
    }

    @Override
    public void save(ProductEntity productEntity) {

    }

    private void executeGoods(OrderCreated event) {
    }

}
