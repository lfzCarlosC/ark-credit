package com.cryptal.ark.arkcreditservice.push.dao;

import com.cryptal.ark.arkcreditservice.push.domain.PushMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PushMessageDao extends JpaRepository<PushMessage,Long> {
}
