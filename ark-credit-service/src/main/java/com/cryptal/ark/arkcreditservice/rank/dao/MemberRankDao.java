package com.cryptal.ark.arkcreditservice.rank.dao;

import com.cryptal.ark.arkcreditservice.rank.domain.MemberRank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRankDao extends JpaRepository<MemberRank,Long> {
}
