package com.cryptal.ark.arkcreditservice.goods.dubbo;

import cn.com.gome.cloud.openplatform.common.PageObject;
import cn.com.gome.cloud.openplatform.common.SearchFilter;
import cn.com.gome.cloud.openplatform.open.OpenConverterUtils;
import com.alibaba.dubbo.config.annotation.Service;
import com.cryptal.ark.arkcreditservice.goods.entity.SellAttributeEntity;
import com.cryptal.ark.arkcreditservice.goods.service.SellAttributeService;
import com.cryptal.ark.interfaze.goods.domain.SellAttribute;
import com.cryptal.ark.interfaze.goods.dubbo.goods.SellAttributeDubboService;
import org.springframework.beans.factory.annotation.Autowired;

@Service(group="ark-credit-service")
public class SellAttributeDubboServiceImpl implements SellAttributeDubboService {

    @Autowired
    private SellAttributeService sellAttributeService;


    @Override
    public PageObject<SellAttribute> page(SearchFilter searchFilter) {
        return OpenConverterUtils.convertPageObject(sellAttributeService.paged(searchFilter));
    }

    @Override
    public SellAttribute get(Long id) {
        return OpenConverterUtils.convertObject(sellAttributeService.get(id));
    }

    @Override
    public SellAttribute get(SearchFilter searchFilter) {
        return OpenConverterUtils.convertObject(sellAttributeService.get(searchFilter));
    }

    @Override
    public void saveOrUpdate(SellAttribute sellAttribute) {
        sellAttributeService.insert(SellAttributeEntity.constructFrom(sellAttribute));
    }

    @Override
    public void delete(Long id) {
        sellAttributeService.delete(id);
    }
}
