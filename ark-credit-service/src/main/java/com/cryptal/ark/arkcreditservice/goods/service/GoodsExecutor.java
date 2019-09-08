package com.cryptal.ark.arkcreditservice.goods.service;

/**
 * 购买商品触发的处理器
 */
public interface GoodsExecutor {

    /**
     * 商品被购买触发的Executor
     * @param goodsId
     * @param userId
     */
    void execute(Long goodsId, Long userId);

}
