package com.cryptal.ark.arkcreditservice.config.service;

public interface ConfigService {


    /**
     * 邀请新用户奖励
     * @return
     */
    int getInviteUserReward();

    /**
     * 新注册用户奖励
     * @return
     */
    int getNewUserReward();
}
