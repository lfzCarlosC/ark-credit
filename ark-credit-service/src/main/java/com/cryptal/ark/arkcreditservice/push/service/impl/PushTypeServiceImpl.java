package com.cryptal.ark.arkcreditservice.push.service.impl;

import cn.com.gome.cloud.openplatform.repository.GenericDao;
import cn.com.gome.cloud.openplatform.service.impl.GenericServiceImpl;
import com.cryptal.ark.arkcreditservice.push.dao.PushTypeDao;
import com.cryptal.ark.arkcreditservice.push.entity.PushTypeEntity;
import com.cryptal.ark.arkcreditservice.push.service.PushTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PushTypeServiceImpl extends GenericServiceImpl<PushTypeEntity,Long> implements PushTypeService {

    @Autowired
    private PushTypeDao pushTypeDao;

    @Override
    protected GenericDao<PushTypeEntity, Long> getDao() {
        return pushTypeDao;
    }

}
