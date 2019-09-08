package com.cryptal.ark.arkcreditservice.user.event;

import org.springframework.context.ApplicationEvent;

/**
 * 用户被指定某个等级
 */
public class UserRankAssigned extends ApplicationEvent {

    private Long userId;

    private Long rankId;

    private int days;

    public UserRankAssigned(Object source,Long userId,Long rankId,int days) {
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
