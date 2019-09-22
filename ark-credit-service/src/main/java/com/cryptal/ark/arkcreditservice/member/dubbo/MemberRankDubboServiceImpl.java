package com.cryptal.ark.arkcreditservice.member.dubbo;

import cn.com.gome.cloud.openplatform.common.PageObject;
import cn.com.gome.cloud.openplatform.common.SearchFilter;
import cn.com.gome.cloud.openplatform.open.OpenConverterUtils;
import com.alibaba.dubbo.config.annotation.Service;
import com.cryptal.ark.arkcreditservice.member.entity.MemberRankEntity;
import com.cryptal.ark.arkcreditservice.member.service.MemberRankService;
import com.cryptal.ark.interfaze.member.domain.MemberRank;
import com.cryptal.ark.interfaze.member.dubbo.MemberRankDubboService;
import org.springframework.beans.factory.annotation.Autowired;

@Service(group="ark-credit-service")
public class MemberRankDubboServiceImpl implements MemberRankDubboService {

    @Autowired
    private MemberRankService memberRankService;

    @Override
    public MemberRank get(Long id) {
        return OpenConverterUtils.convertObject(memberRankService.get(id));
    }

    @Override
    public MemberRank get(SearchFilter searchFilter) {
        return OpenConverterUtils.convertObject(memberRankService.get(searchFilter));
    }

    @Override
    public PageObject<MemberRank> page(SearchFilter searchFilter) {
        return OpenConverterUtils.convertPageObject(memberRankService.paged(searchFilter));
    }

    @Override
    public void saveOrUpdate(MemberRank memberRank) {
        memberRankService.insert(MemberRankEntity.constructFrom(memberRank));
    }

    @Override
    public void delete(Long id) {
        memberRankService.delete(id);
    }
}
