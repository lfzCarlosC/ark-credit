package com.cryptal.ark.arkcreditservice.user.service.impl;

import com.cryptal.ark.arkcreditservice.user.dao.DeviceDao;
import com.cryptal.ark.arkcreditservice.user.domain.Device;
import com.cryptal.ark.arkcreditservice.user.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    private DeviceDao deviceDao;

    @Override
    public void insert(Device device) {
        deviceDao.save(device);
    }

    @Override
    public List<Device> findByIds(List<Long> userIds) {
        return null;
    }


}
