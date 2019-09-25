package com.cryptal.ark.arkcreditservice.goods.dubbo;

import cn.com.gome.cloud.openplatform.common.PageObject;
import cn.com.gome.cloud.openplatform.common.SearchFilter;
import cn.com.gome.cloud.openplatform.open.OpenConverterUtils;
import com.alibaba.dubbo.config.annotation.Service;
import com.cryptal.ark.arkcreditservice.goods.entity.GoodsImageEntity;
import com.cryptal.ark.arkcreditservice.goods.entity.GoodsSkuEntity;
import com.cryptal.ark.arkcreditservice.goods.service.GoodsSkuService;
import com.cryptal.ark.interfaze.goods.domain.GoodsSku;
import com.cryptal.ark.interfaze.goods.dubbo.goods.GoodsSkuDubboService;
import com.cryptal.ark.interfaze.goods.request.GoodsSkuAddedRequest;
import org.springframework.beans.factory.annotation.Autowired;

@Service(group="ark-credit-service")
public class GoodsSkuDubboServiceImpl implements GoodsSkuDubboService {

    @Autowired
    private GoodsSkuService goodsSkuService;

    @Override
    public PageObject<GoodsSku> paged(SearchFilter searchFilter) {
        return OpenConverterUtils.convertPageObject(goodsSkuService.paged(searchFilter));
    }

    @Override
    public GoodsSku get(Long id) {
        return OpenConverterUtils.convertObject(goodsSkuService.get(id));
    }

    @Override
    public GoodsSku get(SearchFilter searchFilter) {
        return OpenConverterUtils.convertObject(goodsSkuService.get(searchFilter));
    }

    @Override
    public void saveOrUpdate(GoodsSku goodsSku) {
        goodsSkuService.insert(GoodsSkuEntity.constructFrom(goodsSku));
    }

    @Override
    public void delete(Long id) {
        goodsSkuService.delete(id);
    }

    @Override
    public void createSku(GoodsSkuAddedRequest goodsSkuAddedRequest) {

    }
}
