package com.cryptal.ark.arkcreditservice.rank.service.impl;

import com.cryptal.ark.arkcreditservice.rank.dao.RankDao;
import com.cryptal.ark.arkcreditservice.rank.domain.Rank;
import com.cryptal.ark.arkcreditservice.rank.domain.RankConstant;
import com.cryptal.ark.arkcreditservice.rank.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RankServiceImpl implements RankService {

    @Autowired
    private RankDao rankDao;

//    @PostConstruct
//    public void init(){
//        this.initRank(RankConstant.NORMAL_USER,RankConstant.COMPANY,RankConstant.DIAMOND_LEVEL,RankConstant.GOLDEN_LEVEL,RankConstant.STAKE_HOLDER);
//    }

    /**
     * 初始化角色
     * @param rankConstants
     */
    private void initRank(RankConstant... rankConstants) {
        for (RankConstant rankConstant : rankConstants) {
            rankDao.save(new Rank(rankConstant.getRankId(),rankConstant.getName()));
        }
    }

    @Override
    public void insert(Rank rank) {
        rankDao.save(rank);
    }
}
