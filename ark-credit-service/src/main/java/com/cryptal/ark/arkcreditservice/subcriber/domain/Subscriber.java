package com.cryptal.ark.arkcreditservice.subcriber.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * 订阅者信息
 */
@Entity
public class Subscriber implements Serializable {

    @Id
    private Long id;

    /**
     * 消息主题ID
     */
    private Long messageTopicId;

    /**
     * 用户ID
     */
    private Long userId;


}
