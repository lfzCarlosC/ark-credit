package com.cryptal.ark.arkcreditservice.user.dao;

import com.cryptal.ark.arkcreditservice.user.domain.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceDao extends JpaRepository<Device,Long> {
}
