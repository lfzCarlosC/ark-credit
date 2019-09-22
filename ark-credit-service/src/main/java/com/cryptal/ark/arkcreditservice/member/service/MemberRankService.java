package com.cryptal.ark.arkcreditservice.member.service;

import cn.com.gome.cloud.openplatform.service.GenericService;
import com.cryptal.ark.arkcreditservice.member.entity.MemberRankEntity;

public interface MemberRankService extends GenericService<MemberRankEntity,Long> {

    /**
     *
     * @return
     * @param rankId
     * @param level
     */
    int computeRebatePercent(Long rankId, int level);
}
