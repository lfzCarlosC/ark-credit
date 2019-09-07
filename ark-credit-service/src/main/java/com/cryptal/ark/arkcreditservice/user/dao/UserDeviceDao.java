package com.cryptal.ark.arkcreditservice.user.dao;

import com.cryptal.ark.arkcreditservice.user.domain.UserDevice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDeviceDao extends JpaRepository<UserDevice,Long> {
}
