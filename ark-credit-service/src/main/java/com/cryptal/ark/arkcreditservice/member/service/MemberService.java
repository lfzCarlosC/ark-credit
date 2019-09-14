package com.cryptal.ark.arkcreditservice.member.service;

import com.cryptal.ark.arkcreditservice.member.domain.MemberRank;
import com.cryptal.ark.arkcreditservice.rank.domain.RankConstant;

import java.util.List;

public interface MemberService {

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

    /**
     * 设置用户为某个等级多少天
     * @param userId
     * @param rankId
     * @param days
     */
    void assignUserWithRank(Long userId, Long rankId, int days);

    /**
     * 添加会员
     * @param userId
     * @param normalUser
     */
    void addMember(Long userId, RankConstant normalUser);
}
