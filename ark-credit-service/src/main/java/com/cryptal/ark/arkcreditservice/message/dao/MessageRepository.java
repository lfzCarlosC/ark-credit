package com.cryptal.ark.arkcreditservice.message.dao;

import com.cryptal.ark.arkcreditservice.message.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message,Long> {
}
