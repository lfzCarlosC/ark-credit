package com.cryptal.ark.arkcreditservice.configuration.dao;

import com.cryptal.ark.arkcreditservice.configuration.domain.Config;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfigRepository extends JpaRepository<Config,Long> {
}
