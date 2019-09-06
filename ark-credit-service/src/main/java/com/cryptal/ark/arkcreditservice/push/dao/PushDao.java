package com.cryptal.ark.arkcreditservice.push.dao;

import com.cryptal.ark.arkcreditservice.push.domain.Push;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PushDao extends JpaRepository<Push,Long> {
}
