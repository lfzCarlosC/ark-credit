package com.cryptal.ark.arkcreditservice.member.dao;

import com.cryptal.ark.arkcreditservice.member.domain.MemberRank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRankDao extends JpaRepository<MemberRank,Long> {
    List<MemberRank> findByUserId(Long userId);
}
