package com.cryptal.ark.arkcreditservice.configuration.service.impl;

import com.cryptal.ark.arkcreditservice.configuration.dao.ConfigRepository;
import com.cryptal.ark.arkcreditservice.configuration.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConfigServiceImpl implements ConfigService {

    @Autowired
    private ConfigRepository configRepository;

    @Override
    public Long getInviteUserReward() {
        return 0L;
    }

    @Override
    public Long getNewUserReward() {
        return 0L;
    }
}
