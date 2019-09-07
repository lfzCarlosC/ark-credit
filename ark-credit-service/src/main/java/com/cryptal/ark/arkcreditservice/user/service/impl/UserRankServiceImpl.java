package com.cryptal.ark.arkcreditservice.user.service.impl;

import com.cryptal.ark.arkcreditservice.user.dao.UserRankDao;
import com.cryptal.ark.arkcreditservice.user.domain.UserRank;
import com.cryptal.ark.arkcreditservice.user.service.UserRankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserRankServiceImpl implements UserRankService {

    @Autowired
    private UserRankDao userRankDao;

    @Override
    public List<Long> findUserIdsByRankId(Long rankId) {
        return null;
    }

    @Override
    public void bindRankWithUserId(Long userId, Long rankId, int delayDays) {

    }

    @Override
    public List<UserRank> findExpired() {
        return null;
    }

    @Override
    public List<UserRank> findByUserId(Long userId) {
        return null;
    }

    @Override
    public void removeExpireUser(Long userId) {
        List<UserRank> userRankList = userRankDao.findByUserId(userId);
        userRankDao.deleteAll(userRankList);
    }
}
