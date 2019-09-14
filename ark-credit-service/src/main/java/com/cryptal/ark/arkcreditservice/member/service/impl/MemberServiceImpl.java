package com.cryptal.ark.arkcreditservice.member.service.impl;

import com.cryptal.ark.arkcreditservice.member.dao.MemberDao;
import com.cryptal.ark.arkcreditservice.member.domain.MemberRank;
import com.cryptal.ark.arkcreditservice.member.service.MemberService;
import com.cryptal.ark.arkcreditservice.rank.domain.RankConstant;
import com.cryptal.ark.arkcreditservice.user.event.UserRankAssigned;
import com.cryptal.ark.arkcreditservice.user.event.UserRankExpired;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDao memberDao;

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
            publisher.publishEvent(new UserRankExpired(this, memberRank.getUserId()));
        }
    }

    @Override
    public void removeMember(Long userId) {

    }

    @Override
    public void assignUserWithRank(Long userId, Long rankId, int days) {
        publisher.publishEvent(new UserRankAssigned(this,userId,rankId,days));
    }

    @Override
    public void addMember(Long userId, RankConstant normalUser) {

    }

    /**
     * 查询会员到期的会员
     * @return
     */
    private List<MemberRank> findExpiredMembers() {
        return Lists.newArrayList();
    }
}
