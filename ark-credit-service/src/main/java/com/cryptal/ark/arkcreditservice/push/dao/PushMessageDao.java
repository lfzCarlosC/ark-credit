package com.cryptal.ark.arkcreditservice.push.dao;

import com.cryptal.ark.arkcreditservice.push.entity.PushMessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PushMessageDao extends JpaRepository<PushMessageEntity,Long> {
}
