package com.cryptal.ark.arkcreditservice.goods.service.impl;

import cn.com.gome.cloud.openplatform.repository.GenericDao;
import cn.com.gome.cloud.openplatform.service.impl.GenericServiceImpl;
import com.cryptal.ark.arkcreditservice.common.exp.CreditException;
import com.cryptal.ark.arkcreditservice.goods.dao.GoodsSkuDao;
import com.cryptal.ark.arkcreditservice.goods.entity.GoodsSkuEntity;
import com.cryptal.ark.arkcreditservice.goods.service.GoodsSkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Optional;

@Component
public class GoodsSkuServiceImpl extends GenericServiceImpl<GoodsSkuEntity,Long> implements GoodsSkuService {

    @Autowired
    private GoodsSkuDao goodsSkuDao;

    @Override
    protected GenericDao<GoodsSkuEntity, Long> getDao() {
        return goodsSkuDao;
    }

    @Override
    public GoodsSkuEntity checkAndGet(Long id) {
        Optional<GoodsSkuEntity> goodsSkuEntityOptional = goodsSkuDao.findById(id);
        if(goodsSkuEntityOptional.isPresent()){
            return goodsSkuEntityOptional.get();
        }
        throw new CreditException("商品ID不存在" + id);
    }

    @Override
    public void enable(Long id) {
        GoodsSkuEntity goodsSkuEntity = this.checkAndGet(id);
        goodsSkuEntity.setOnSale(true);
        goodsSkuEntity.setModifyTime(new Date());
        goodsSkuDao.save(goodsSkuEntity);
    }

    @Override
    public void disable(Long id) {
        GoodsSkuEntity goodsSkuEntity = this.checkAndGet(id);
        goodsSkuEntity.setOnSale(false);
        goodsSkuEntity.setModifyTime(new Date());
        goodsSkuDao.save(goodsSkuEntity);
    }

}
