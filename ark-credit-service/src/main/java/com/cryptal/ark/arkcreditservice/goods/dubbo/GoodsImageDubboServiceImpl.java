package com.cryptal.ark.arkcreditservice.goods.dubbo;

import cn.com.gome.cloud.openplatform.common.PageObject;
import cn.com.gome.cloud.openplatform.common.SearchFilter;
import cn.com.gome.cloud.openplatform.open.OpenConverterUtils;
import com.alibaba.dubbo.config.annotation.Service;
import com.cryptal.ark.arkcreditservice.goods.entity.GoodsImageEntity;
import com.cryptal.ark.arkcreditservice.goods.service.GoodsImageService;
import com.cryptal.ark.interfaze.goods.domain.GoodsImage;
import com.cryptal.ark.interfaze.goods.dubbo.goods.GoodsImageDubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service(group="ark-credit-service")
public class GoodsImageDubboServiceImpl implements GoodsImageDubboService {

    @Autowired
    private GoodsImageService goodsImageService;

    @Override
    public PageObject<GoodsImage> paged(SearchFilter searchFilter) {
        return OpenConverterUtils.convertPageObject(goodsImageService.paged(searchFilter));
    }

    @Override
    public GoodsImage get(Long id) {
        return OpenConverterUtils.convertObject(goodsImageService.get(id));
    }

    @Override
    public GoodsImage get(SearchFilter searchFilter) {
        return OpenConverterUtils.convertObject(goodsImageService.get(searchFilter));
    }

    @Override
    public void saveOrUpdate(GoodsImage goodsImage) {
        goodsImageService.insert(GoodsImageEntity.constructFrom(goodsImage));
    }

    @Override
    public void delete(Long id) {
        goodsImageService.delete(id);
    }

    @Override
    public List<GoodsImage> findBySkuId(Long skuId) {
        return OpenConverterUtils.convertList(goodsImageService.findBySkuId(skuId));
    }
}
