package com.cryptal.ark.arkcreditservice.push.dubbo;

import cn.com.gome.cloud.openplatform.common.PageObject;
import cn.com.gome.cloud.openplatform.common.SearchFilter;
import cn.com.gome.cloud.openplatform.open.OpenConverterUtils;
import com.alibaba.dubbo.config.annotation.Service;
import com.cryptal.ark.arkcreditservice.push.entity.PushTypeEntity;
import com.cryptal.ark.arkcreditservice.push.service.PushTypeService;
import com.cryptal.ark.interfaze.push.domain.PushType;
import com.cryptal.ark.interfaze.push.dubbo.PushTypeDubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service(group="ark-credit-service")
public class PushTypeDubboServiceImpl implements PushTypeDubboService {

    @Autowired
    private PushTypeService pushTypeService;

    @Override
    public PageObject<PushType> page(SearchFilter searchFilter) {
        return OpenConverterUtils.convertPageObject(pushTypeService.paged(searchFilter));
    }

    @Override
    public PushType get(Long id) {
        return OpenConverterUtils.convertObject(pushTypeService.get(id));
    }

    @Override
    public PushType get(SearchFilter searchFilter) {
        return OpenConverterUtils.convertObject(pushTypeService.get(searchFilter));
    }

    @Override
    public void saveOrUpdate(PushType pushType) {
        pushTypeService.insert(PushTypeEntity.constructFrom(pushType));
    }

    @Override
    public void delete(Long id) {
        pushTypeService.delete(id);
    }

    @Override
    public List<PushType> findAll() {
        return OpenConverterUtils.convertList(pushTypeService.list(SearchFilter.getDefault()));
    }
}
