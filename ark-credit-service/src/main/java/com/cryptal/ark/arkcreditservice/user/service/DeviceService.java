package com.cryptal.ark.arkcreditservice.user.service;

import com.cryptal.ark.arkcreditservice.user.domain.Device;

import java.util.List;

public interface DeviceService {

    /**
     * 添加用户设备
     * @param device
     */
    void insert(Device device);

    /**
     * 根据用户ID查询所有的设备
     * @param userIds
     * @return
     */
    List<Device> findByIds(List<Long> userIds);
}
