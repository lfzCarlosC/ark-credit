package com.cryptal.ark.arkcreditservice.rank.service;

import com.cryptal.ark.arkcreditservice.rank.domain.MemberRank;

public interface MemberRankService {

    void insert(MemberRank memberRank);

    /**
     *
     * @return
     * @param rankId
     * @param level
     */
    int computeRebatePercent(Long rankId, int level);
}
