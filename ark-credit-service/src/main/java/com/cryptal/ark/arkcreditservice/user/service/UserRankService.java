package com.cryptal.ark.arkcreditservice.user.service;

import com.cryptal.ark.arkcreditservice.user.domain.UserRank;

import java.util.List;

public interface UserRankService {

    List<Long> findUserIdsByRankId(Long rankId);

    /**
     * 绑定用户到等级
     * @param userId
     * @param rankId
     * @param delayDays
     */
    void bindRankWithUserId(Long userId, Long rankId, int delayDays);

    /**
     * 获取所有过期的用户等级信息
     * @return
     */
    List<UserRank> findExpired();

    /**
     * 根据用户ID获取所有的等级信息
     * @param userId
     * @return
     */
    List<UserRank> findByUserId(Long userId);

    /**
     * 移除过期用户
     * @param userId
     */
    void removeExpireUser(Long userId);
}
