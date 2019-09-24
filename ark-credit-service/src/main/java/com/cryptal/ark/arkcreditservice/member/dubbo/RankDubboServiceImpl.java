package com.cryptal.ark.arkcreditservice.member.dubbo;

import cn.com.gome.cloud.openplatform.common.PageObject;
import cn.com.gome.cloud.openplatform.common.SearchFilter;
import cn.com.gome.cloud.openplatform.open.OpenConverterUtils;
import com.alibaba.dubbo.config.annotation.Service;
import com.cryptal.ark.arkcreditservice.member.entity.RankEntity;
import com.cryptal.ark.arkcreditservice.member.service.RankService;
import com.cryptal.ark.interfaze.member.domain.Rank;
import com.cryptal.ark.interfaze.member.dubbo.RankDubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service(group="ark-credit-service")
public class RankDubboServiceImpl implements RankDubboService {

    @Autowired
    private RankService rankService;

    @Override
    public Rank get(Long id) {
        return OpenConverterUtils.convertObject(rankService.get(id));
    }

    @Override
    public Rank get(SearchFilter searchFilter) {
        return OpenConverterUtils.convertObject(rankService.get(searchFilter));
    }

    @Override
    public PageObject<Rank> page(SearchFilter searchFilter) {
        return OpenConverterUtils.convertPageObject(rankService.paged(searchFilter));
    }

    @Override
    public void saveOrUpdate(Rank rank) {
        rankService.insert(RankEntity.constructFrom(rank));
    }

    @Override
    public void delete(Long id) {
        rankService.delete(id);
    }

    @Override
    public List<Rank> findAll() {
        return OpenConverterUtils.convertList(rankService.list(SearchFilter.getDefault()));
    }
}
