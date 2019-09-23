package com.cryptal.ark.arkcreditservice.push.dubbo;

import cn.com.gome.cloud.openplatform.common.PageObject;
import cn.com.gome.cloud.openplatform.common.SearchFilter;
import cn.com.gome.cloud.openplatform.open.OpenConverterUtils;
import com.alibaba.dubbo.config.annotation.Service;
import com.cryptal.ark.arkcreditservice.push.entity.PushPermissionEntity;
import com.cryptal.ark.arkcreditservice.push.service.PushPermissionService;
import com.cryptal.ark.interfaze.push.domain.PushPermission;
import com.cryptal.ark.interfaze.push.dubbo.PushPermissionDubboService;
import org.springframework.beans.factory.annotation.Autowired;

@Service(group="ark-credit-service")
public class PushPermissionDubboServiceImpl implements PushPermissionDubboService {

    @Autowired
    private PushPermissionService pushPermissionService;

    @Override
    public PageObject<PushPermission> page(SearchFilter searchFilter) {
        return OpenConverterUtils.convertPageObject(pushPermissionService.paged(searchFilter));
    }

    @Override
    public PushPermission get(Long id) {
        return OpenConverterUtils.convertObject(pushPermissionService.get(id));
    }

    @Override
    public PushPermission get(SearchFilter searchFilter) {
        return OpenConverterUtils.convertObject(pushPermissionService.get(searchFilter));
    }

    @Override
    public void saveOrUpdate(PushPermission pushPermission) {
        pushPermissionService.insert(PushPermissionEntity.constructFrom(pushPermission));
    }

    @Override
    public void delete(Long id) {
        pushPermissionService.delete(id);
    }
}
