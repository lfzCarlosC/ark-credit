package com.cryptal.ark.interfaze.goods.dubbo.goods;

import cn.com.gome.cloud.openplatform.common.PageObject;
import cn.com.gome.cloud.openplatform.common.SearchFilter;
import com.cryptal.ark.interfaze.goods.domain.GoodsImage;

public interface GoodsImageDubboService {

    PageObject<GoodsImage> paged(SearchFilter searchFilter);

    GoodsImage get(Long id);

    GoodsImage get(SearchFilter searchFilter);

    void saveOrUpdate(GoodsImage goodsImage);

    void delete(Long id);

}
