package com.cryptal.ark.arkcreditservice.rank.service.impl;

import com.cryptal.ark.arkcreditservice.rank.dao.RankDao;
import com.cryptal.ark.arkcreditservice.rank.domain.Rank;
import com.cryptal.ark.arkcreditservice.rank.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RankServiceImpl implements RankService {

    @Autowired
    private RankDao rankDao;

    @Override
    public void insert(Rank rank) {
        rankDao.save(rank);
    }
}
