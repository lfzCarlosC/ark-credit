package com.cryptal.ark.interfaze.member.dubbo;

import cn.com.gome.cloud.openplatform.common.PageObject;
import cn.com.gome.cloud.openplatform.common.SearchFilter;
import com.cryptal.ark.interfaze.member.domain.MemberRank;

public interface MemberRankDubboService {

    MemberRank get(Long id);

    MemberRank get(SearchFilter searchFilter);

    PageObject<MemberRank> page(SearchFilter searchFilter);

    void saveOrUpdate(MemberRank memberRank);

    void delete(Long id);
}
