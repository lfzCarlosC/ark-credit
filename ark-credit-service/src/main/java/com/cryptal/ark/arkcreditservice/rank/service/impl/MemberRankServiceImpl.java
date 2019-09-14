package com.cryptal.ark.arkcreditservice.rank.service.impl;

import com.cryptal.ark.arkcreditservice.rank.dao.MemberRankDao;
import com.cryptal.ark.arkcreditservice.rank.domain.MemberRank;
import com.cryptal.ark.arkcreditservice.rank.service.MemberRankService;
import com.cryptal.ark.arkcreditservice.user.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MemberRankServiceImpl implements MemberRankService {

    @Autowired
    private MemberRankDao memberRankDao;

    @Autowired
    private UserDao userDao;

    @Override
    public void insert(MemberRank memberRank) {
        memberRankDao.save(memberRank);
    }

    @Override
    public int computeRebatePercent(Long rankId, int level) {

        Optional<MemberRank> memberRankOptional = memberRankDao.findById(rankId);

        MemberRank memberRank = memberRankOptional.get();

        return memberRank.getRebatePercentLevel1();
    }
}
