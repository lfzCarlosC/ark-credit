package com.cryptal.ark.interfaze.member.dubbo;

import cn.com.gome.cloud.openplatform.common.PageObject;
import cn.com.gome.cloud.openplatform.common.SearchFilter;
import com.cryptal.ark.interfaze.member.domain.Rank;

import java.util.List;

public interface RankDubboService {

    Rank get(Long id);

    Rank get(SearchFilter searchFilter);

    PageObject<Rank> page(SearchFilter searchFilter);

    void saveOrUpdate(Rank rank);

    void delete(Long id);

    List<Rank> findAll();
}
