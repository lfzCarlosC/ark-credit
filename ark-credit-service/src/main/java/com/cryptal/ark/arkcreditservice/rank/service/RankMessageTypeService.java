package com.cryptal.ark.arkcreditservice.rank.service;

import com.cryptal.ark.arkcreditservice.rank.domain.RankMessageType;

import java.util.List;

public interface RankMessageTypeService {

    /**
     * 获取等级消息对应信息
     * @param messageTypeId     消息类型
     * @return
     */
    List<RankMessageType> findByMessageTypeId(long messageTypeId);

    /**
     * 绑定等级和消息类型关系
     */
    void bindRankWithMessageType(Long rankId, Long messageTypeId);
}
