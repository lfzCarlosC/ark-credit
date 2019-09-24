package com.cryptal.ark.arkcreditservice.member.dubbo;

import cn.com.gome.cloud.openplatform.common.PageObject;
import cn.com.gome.cloud.openplatform.common.SearchFilter;
import cn.com.gome.cloud.openplatform.open.OpenConverterUtils;
import com.alibaba.dubbo.config.annotation.Service;
import com.cryptal.ark.arkcreditservice.member.entity.RankPermissionEntity;
import com.cryptal.ark.arkcreditservice.member.service.RankPermissionService;
import com.cryptal.ark.interfaze.member.domain.RankPermission;
import com.cryptal.ark.interfaze.member.dubbo.RankPermissionDubboService;
import org.springframework.beans.factory.annotation.Autowired;

@Service(group="ark-credit-service")
public class RankPermissionDubboServiceImpl implements RankPermissionDubboService {

    @Autowired
    private RankPermissionService rankPermissionService;

    @Override
    public RankPermission get(Long id) {
        return OpenConverterUtils.convertObject(rankPermissionService.get(id));
    }

    @Override
    public RankPermission get(SearchFilter searchFilter) {
        return OpenConverterUtils.convertObject(rankPermissionService.get(searchFilter));
    }

    @Override
    public PageObject<RankPermission> page(SearchFilter searchFilter) {
        return OpenConverterUtils.convertPageObject(rankPermissionService.paged(searchFilter));
    }

    @Override
    public void saveOrUpdate(RankPermission rankPermission) {
        rankPermissionService.insert(RankPermissionEntity.constructFrom(rankPermission));
    }

    @Override
    public void delete(Long id) {
        rankPermissionService.delete(id);
    }
}
