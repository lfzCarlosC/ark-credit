package com.cryptal.ark.arkcreditservice.push.service.impl;

import cn.com.gome.cloud.openplatform.repository.GenericDao;
import cn.com.gome.cloud.openplatform.service.impl.GenericServiceImpl;
import com.cryptal.ark.arkcreditservice.push.dao.PushPermissionDao;
import com.cryptal.ark.arkcreditservice.push.entity.PushPermissionEntity;
import com.cryptal.ark.arkcreditservice.push.service.PushPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PushPermissionServiceImpl extends GenericServiceImpl<PushPermissionEntity,Long> implements PushPermissionService {

    @Autowired
    private PushPermissionDao pushPermissionDao;

    @Override
    protected GenericDao<PushPermissionEntity, Long> getDao() {
        return pushPermissionDao;
    }

}
