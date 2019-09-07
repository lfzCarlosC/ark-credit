package com.cryptal.ark.arkcreditservice.rank.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * 等级可以推送的消息类别
 */
@Entity
public class RankMessageType implements Serializable {

    @Id
    private Long id;

    private Long rankId;

    /**
     * 消息类型
     */
    private Long messageTypeId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRankId() {
        return rankId;
    }

    public void setRankId(Long rankId) {
        this.rankId = rankId;
    }

    public Long getMessageTypeId() {
        return messageTypeId;
    }

    public void setMessageTypeId(Long messageTypeId) {
        this.messageTypeId = messageTypeId;
    }

}
