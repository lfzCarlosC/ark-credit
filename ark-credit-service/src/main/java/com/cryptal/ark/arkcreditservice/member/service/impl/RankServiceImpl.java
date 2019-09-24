package com.cryptal.ark.arkcreditservice.member.service.impl;

import cn.com.gome.cloud.openplatform.repository.GenericDao;
import cn.com.gome.cloud.openplatform.service.impl.GenericServiceImpl;
import com.cryptal.ark.arkcreditservice.member.dao.RankDao;
import com.cryptal.ark.arkcreditservice.member.entity.RankEntity;
import com.cryptal.ark.arkcreditservice.member.service.RankService;
import com.cryptal.ark.arkcreditservice.user.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RankServiceImpl extends GenericServiceImpl<RankEntity,Long> implements RankService {

    @Autowired
    private RankDao rankDao;

    @Autowired
    private UserDao userDao;

    @Override
    protected GenericDao<RankEntity, Long> getDao() {
        return rankDao;
    }

    @Override
    public int computeRebatePercent(Long rankId, int level) {

        Optional<RankEntity> memberRankOptional = rankDao.findById(rankId);

        RankEntity rankEntity = memberRankOptional.get();

        return rankEntity.getRebatePercentLevel1();
    }

}
