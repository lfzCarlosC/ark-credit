package com.cryptal.ark.arkcreditservice.goods.dubbo;

import cn.com.gome.cloud.openplatform.common.PageObject;
import cn.com.gome.cloud.openplatform.common.SearchFilter;
import cn.com.gome.cloud.openplatform.open.OpenConverterUtils;
import com.alibaba.dubbo.config.annotation.Service;
import com.cryptal.ark.arkcreditservice.goods.entity.SellAttributeValueEntity;
import com.cryptal.ark.arkcreditservice.goods.service.SellAttributeValueService;
import com.cryptal.ark.interfaze.goods.domain.SellAttributeValue;
import com.cryptal.ark.interfaze.goods.dubbo.goods.SellAttributeValueDubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service(group="ark-credit-service")
public class SellAttributeValueDubboServiceImpl implements SellAttributeValueDubboService {

    @Autowired
    private SellAttributeValueService sellAttributeValueService;

    @Override
    public PageObject<SellAttributeValue> page(SearchFilter searchFilter) {
        return OpenConverterUtils.convertPageObject(sellAttributeValueService.paged(searchFilter));
    }

    @Override
    public SellAttributeValue get(Long id) {
        return OpenConverterUtils.convertObject(sellAttributeValueService.get(id));
    }

    @Override
    public SellAttributeValue get(SearchFilter searchFilter) {
        return OpenConverterUtils.convertObject(sellAttributeValueService.get(searchFilter));
    }

    @Override
    public void saveOrUpdate(SellAttributeValue sellAttributeValue) {
        sellAttributeValueService.insert(SellAttributeValueEntity.constructFrom(sellAttributeValue));
    }

    @Override
    public void delete(Long id) {
        sellAttributeValueService.delete(id);
    }

    @Override
    public List<SellAttributeValue> findByAttributeId(Long sellAttributeId) {
        return OpenConverterUtils.convertList(sellAttributeValueService.findByAttributeId(sellAttributeId));
    }
}
