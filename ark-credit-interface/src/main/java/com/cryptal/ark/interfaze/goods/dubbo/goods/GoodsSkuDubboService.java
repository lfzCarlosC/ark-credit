package com.cryptal.ark.interfaze.goods.dubbo.goods;

import cn.com.gome.cloud.openplatform.common.PageObject;
import cn.com.gome.cloud.openplatform.common.SearchFilter;
import com.cryptal.ark.interfaze.goods.domain.GoodsSku;
import com.cryptal.ark.interfaze.goods.request.GoodsSkuAddedRequest;

public interface GoodsSkuDubboService {

    PageObject<GoodsSku> paged(SearchFilter searchFilter);

    GoodsSku get(Long id);

    GoodsSku get(SearchFilter searchFilter);

    void saveOrUpdate(GoodsSku goodsSku);

    void delete(Long id);

    void createSku(GoodsSkuAddedRequest goodsSkuAddedRequest);
}
