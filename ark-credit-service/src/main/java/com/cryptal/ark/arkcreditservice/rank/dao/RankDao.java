package com.cryptal.ark.arkcreditservice.rank.dao;

import com.cryptal.ark.arkcreditservice.rank.domain.Rank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RankDao extends JpaRepository<Rank,Long> {
}
