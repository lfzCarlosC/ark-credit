package com.cryptal.ark.arkcreditservice.config.service.impl;

import com.cryptal.ark.arkcreditservice.config.dao.ConfigRepository;
import com.cryptal.ark.arkcreditservice.config.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConfigServiceImpl implements ConfigService {

    @Autowired
    private ConfigRepository configRepository;

    @Override
    public int getInviteUserReward() {
        return 0;
    }

    @Override
    public int getNewUserReward() {
        return 0;
    }
}
