package com.cryptal.ark.arkcreditservice.rank.service.impl;

import com.cryptal.ark.arkcreditservice.rank.domain.RankMessageType;
import com.cryptal.ark.arkcreditservice.rank.service.RankMessageTypeService;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class RankMessageTypeServiceImpl implements RankMessageTypeService {
    @Override
    public List<RankMessageType> findByMessageTypeId(long messageTypeId) {
        return null;
    }

    @Override
    public void bindRankWithMessageType(Long rankId, Long messageTypeId) {

    }
}
