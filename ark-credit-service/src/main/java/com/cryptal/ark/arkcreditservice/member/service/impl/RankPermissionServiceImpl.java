package com.cryptal.ark.arkcreditservice.member.service.impl;

import cn.com.gome.cloud.openplatform.repository.GenericDao;
import cn.com.gome.cloud.openplatform.service.impl.GenericServiceImpl;
import com.cryptal.ark.arkcreditservice.member.dao.RankPermissionDao;
import com.cryptal.ark.arkcreditservice.member.entity.RankPermissionEntity;
import com.cryptal.ark.arkcreditservice.member.service.RankPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RankPermissionServiceImpl extends GenericServiceImpl<RankPermissionEntity,Long> implements RankPermissionService {

    @Autowired
    private RankPermissionDao rankPermissionDao;

    @Override
    protected GenericDao<RankPermissionEntity, Long> getDao() {
        return rankPermissionDao;
    }

}
