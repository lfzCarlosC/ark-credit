package com.cryptal.ark.arkcreditmanager.goods.page;

import cn.com.gome.cloud.openplatform.common.PageObject;
import cn.com.gome.cloud.openplatform.common.SearchFilter;
import cn.com.gome.page.core.PageConfig;
import cn.com.gome.page.core.PageContext;
import cn.com.gome.page.core.PageService;
import com.alibaba.dubbo.config.annotation.Reference;
import com.cryptal.ark.interfaze.goods.domain.SellAttribute;
import com.cryptal.ark.interfaze.goods.dubbo.goods.SellAttributeDubboService;
import org.springframework.stereotype.Component;

@Component
public class SellAttributePageService extends PageService<SellAttribute,Long> {

    @Reference(group = "ark-credit-service")
    private SellAttributeDubboService sellAttributeDubboService;

    @Override
    public PageObject<SellAttribute> paged(SearchFilter searchFilter) {
        return sellAttributeDubboService.page(searchFilter);
    }

    @Override
    protected PageConfig initializePageConfig(PageContext pageContext) {
        return null;
    }

    @Override
    public SellAttribute get(String id) {
        return sellAttributeDubboService.get(Long.parseLong(id));
    }

    @Override
    public SellAttribute get(SearchFilter searchFilter) {
        return sellAttributeDubboService.get(searchFilter);
    }

    @Override
    public void saveOrUpdate(SellAttribute sellAttribute) {
        sellAttributeDubboService.saveOrUpdate(sellAttribute);
    }

    @Override
    public void delete(SellAttribute sellAttribute) {
        sellAttributeDubboService.delete(sellAttribute.getId());
    }
}
