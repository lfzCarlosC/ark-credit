package com.cryptal.ark.arkcreditservice.config.service;

public interface ConfigService {


    /**
     * 邀请新用户奖励
     * @return
     */
    Long getInviteUserReward();

    /**
     * 新注册用户奖励
     * @return
     */
    Long getNewUserReward();
}
