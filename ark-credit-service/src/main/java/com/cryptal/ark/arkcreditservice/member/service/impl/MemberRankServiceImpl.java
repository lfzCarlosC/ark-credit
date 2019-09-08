package com.cryptal.ark.arkcreditservice.member.service.impl;

import com.cryptal.ark.arkcreditservice.member.dao.MemberRankDao;
import com.cryptal.ark.arkcreditservice.member.domain.MemberRank;
import com.cryptal.ark.arkcreditservice.member.event.MemberExpired;
import com.cryptal.ark.arkcreditservice.member.service.MemberRankService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MemberRankServiceImpl implements MemberRankService {

    @Autowired
    private MemberRankDao memberRankDao;

    @Autowired
    private ApplicationEventPublisher publisher;

    @Override
    public List<Long> findUserIdsByRankId(Long rankId) {
        return null;
    }


    @Override
    public List<MemberRank> findByUserId(Long userId) {
        return null;
    }


    @Override
    public void removeExpireMembers() {
        List<MemberRank> memberRankList = findExpiredMembers();
        for (MemberRank memberRank : memberRankList) {
            publisher.publishEvent(new MemberExpired(this, memberRank.getUserId()));
        }
    }

    @Override
    public void removeMember(Long userId) {

    }

    /**
     * 查询会员到期的会员
     * @return
     */
    private List<MemberRank> findExpiredMembers() {
        return Lists.newArrayList();
    }
}
