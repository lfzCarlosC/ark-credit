package com.cryptal.ark.arkcreditservice.config.dao;

import com.cryptal.ark.arkcreditservice.config.domain.Config;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfigRepository extends JpaRepository<Config,Long> {
}
