package com.cryptal.ark.arkcreditservice.member.service;

import com.cryptal.ark.arkcreditservice.member.domain.MemberRank;

import java.util.List;

public interface MemberRankService {

    List<Long> findUserIdsByRankId(Long rankId);

    /**
     * 根据用户ID获取所有的等级信息
     * @param userId
     * @return
     */
    List<MemberRank> findByUserId(Long userId);

    /**
     * 移除过期用户
     */
    void removeExpireMembers();

    /**
     * 删除会员
     * @param userId
     */
    void removeMember(Long userId);
}
