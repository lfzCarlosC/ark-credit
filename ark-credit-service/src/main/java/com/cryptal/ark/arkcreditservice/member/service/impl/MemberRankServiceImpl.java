package com.cryptal.ark.arkcreditservice.member.service.impl;

import cn.com.gome.cloud.openplatform.repository.GenericDao;
import cn.com.gome.cloud.openplatform.service.impl.GenericServiceImpl;
import com.cryptal.ark.arkcreditservice.member.dao.MemberRankDao;
import com.cryptal.ark.arkcreditservice.member.entity.MemberRankEntity;
import com.cryptal.ark.arkcreditservice.member.service.MemberRankService;
import com.cryptal.ark.arkcreditservice.user.dao.UserDao;
import com.cryptal.ark.interfaze.member.domain.MemberRank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MemberRankServiceImpl extends GenericServiceImpl<MemberRankEntity,Long> implements MemberRankService {

    @Autowired
    private MemberRankDao memberRankDao;

    @Autowired
    private UserDao userDao;

    @Override
    protected GenericDao<MemberRankEntity, Long> getDao() {
        return memberRankDao;
    }

    @Override
    public int computeRebatePercent(Long rankId, int level) {

        Optional<MemberRankEntity> memberRankOptional = memberRankDao.findById(rankId);

        MemberRankEntity memberRankEntity = memberRankOptional.get();

        return memberRankEntity.getRebatePercentLevel1();
    }

}
