package com.cryptal.ark.arkcreditservice.user.dao;

import com.cryptal.ark.arkcreditservice.user.domain.UserMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMessageDao extends JpaRepository<UserMessage,Long> {
}
