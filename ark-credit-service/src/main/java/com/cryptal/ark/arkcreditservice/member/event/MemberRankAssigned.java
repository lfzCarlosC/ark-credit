package com.cryptal.ark.arkcreditservice.member.event;

import org.springframework.context.ApplicationEvent;

/**
 * 会员等级被指定
 */
public class MemberRankAssigned extends ApplicationEvent {

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 用户等级ID
     */
    private Long rankId;

    /**
     * 时长
     */
    private int days;

    public MemberRankAssigned(Object source, Long userId, Long rankId, int days) {
        super(source);
        this.userId = userId;
        this.rankId = rankId;
        this.days = days;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRankId() {
        return rankId;
    }

    public void setRankId(Long rankId) {
        this.rankId = rankId;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }
}
