package com.cryptal.ark.arkcreditservice.goods.service.impl;

import cn.com.gome.cloud.openplatform.repository.GenericDao;
import cn.com.gome.cloud.openplatform.service.impl.GenericServiceImpl;
import com.cryptal.ark.arkcreditservice.common.exp.CreditException;
import com.cryptal.ark.arkcreditservice.goods.dao.GoodsSellAttributeDao;
import com.cryptal.ark.arkcreditservice.goods.dao.GoodsSkuDao;
import com.cryptal.ark.arkcreditservice.goods.dao.ProductDao;
import com.cryptal.ark.arkcreditservice.goods.dao.SellAttributeValueDao;
import com.cryptal.ark.arkcreditservice.goods.entity.GoodsSkuEntity;
import com.cryptal.ark.arkcreditservice.goods.entity.ProductEntity;
import com.cryptal.ark.arkcreditservice.goods.service.ProductService;
import com.cryptal.ark.arkcreditservice.member.event.MemberRankOrdered;
import com.cryptal.ark.arkcreditservice.order.event.OrderCreated;
import com.cryptal.ark.interfaze.goods.domain.GoodsSku;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductServiceImpl extends GenericServiceImpl<ProductEntity,Long> implements ProductService {

    @Autowired
    private ApplicationEventPublisher publisher;

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

    @Override
    public ProductEntity checkAndGet(Long productId) {
        Optional<ProductEntity> productEntityOptional = productDao.findById(productId);
        if(productEntityOptional.isPresent()){
           return productEntityOptional.get();
        }
        throw new CreditException("产品ID不存在" + productId);
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
        Optional<ProductEntity> goodsOptional = productDao.findById(goodsSkuEntity.getProductId());
        if(!goodsOptional.isPresent()){
            throw new CreditException("商品信息不存在：" + goodsSkuEntity.getProductId());
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
    public void delete(Long id) {
        checkHasGoods(id);
        super.delete(id);
    }

    private void checkHasGoods(Long id) {
        List<GoodsSkuEntity> goodsSkuEntities = goodsSkuDao.findByProductId(id);
        if(goodsSkuEntities.size()>0){
            throw new CreditException("产品下有商品不能删除");
        }
    }

    @Override
    protected GenericDao<ProductEntity, Long> getDao() {
        return productDao;
    }
}
