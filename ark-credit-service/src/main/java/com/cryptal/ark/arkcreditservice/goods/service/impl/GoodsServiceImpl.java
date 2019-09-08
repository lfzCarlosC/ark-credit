package com.cryptal.ark.arkcreditservice.goods.service.impl;

import com.cryptal.ark.arkcreditservice.goods.dao.GoodsDao;
import com.cryptal.ark.arkcreditservice.goods.domain.Goods;
import com.cryptal.ark.arkcreditservice.goods.service.GoodsExecutor;
import com.cryptal.ark.arkcreditservice.goods.service.GoodsService;
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
    private GoodsDao goodsDao;

    @Override
    public void handleOrderCreated(OrderCreated event) {

        decreaseStock(event.getGoodsId(),event.getCount());
        executeGoods(event);

    }

    /**
     * 扣减商品库存
     * @param goodsId
     * @param count
     */
    private void decreaseStock(Long goodsId, Long count) {

    }

    private void executeGoods(OrderCreated event) {
        Optional<Goods> goodsOption = goodsDao.findById(event.getGoodsId());
        if(goodsOption.isPresent()){
            GoodsExecutor goodsExecutor = goodsExecutors.findCurrent(goodsOption.get().getGoodsType());
            goodsExecutor.execute(event.getGoodsId(),event.getUserId());
        }
    }

}
