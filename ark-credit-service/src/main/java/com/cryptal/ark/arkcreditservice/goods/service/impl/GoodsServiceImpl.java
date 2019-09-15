package com.cryptal.ark.arkcreditservice.goods.service.impl;

import com.cryptal.ark.arkcreditservice.common.exp.CreditException;
import com.cryptal.ark.arkcreditservice.goods.dao.GoodsDao;
import com.cryptal.ark.arkcreditservice.goods.dao.GoodsSellAttributeDao;
import com.cryptal.ark.arkcreditservice.goods.dao.GoodsSkuDao;
import com.cryptal.ark.arkcreditservice.goods.dao.SellAttributeValueDao;
import com.cryptal.ark.arkcreditservice.goods.domain.Goods;
import com.cryptal.ark.arkcreditservice.goods.domain.GoodsSku;
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
    private GoodsDao goodsDao;

    @Override
    public void handleOrderCreated(OrderCreated event) {

        GoodsSku goodsSku = checkAndFind(event.getSkuId());

        goodsSku.setStock(goodsSku.getStock()-event.getCount());
        goodsSkuDao.save(goodsSku);

        //如何获得购买的是等级商品，获取等级（黄金会员），获取时长（一个月），发送会员被购买事件

        Goods goods = checkAndFind(goodsSku);

        if(checkIsRankGoods(goods)){
            publisher.publishEvent(new MemberRankOrdered(this,event.getSkuId(),event.getUserId()));
        }

    }

    /**
     * 校验商品是等级商品
     * @param goods
     * @return
     */
    private boolean checkIsRankGoods(Goods goods) {
        return false;
    }


    private Goods checkAndFind(GoodsSku goodsSku) {
        Optional<Goods> goodsOptional = goodsDao.findById(goodsSku.getGoodsId());
        if(!goodsOptional.isPresent()){
            throw new CreditException("商品信息不存在：" + goodsSku.getGoodsId());
        }
        return goodsOptional.get();
    }

    private GoodsSku checkAndFind(Long skuId) {
        Optional<GoodsSku> goodsSkuOptional = goodsSkuDao.findById(skuId);
        if(!goodsSkuOptional.isPresent()){
            throw new CreditException("商品SKU信息不存在" + skuId);
        }

        return goodsSkuOptional.get();
    }

    @Override
    public Goods findById(Long id) {
        return null;
    }

    @Override
    public void save(Goods goods) {

    }

    private void executeGoods(OrderCreated event) {
    }

}
