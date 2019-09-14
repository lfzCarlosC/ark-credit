package com.cryptal.ark.arkcreditservice.member.dao;

import com.cryptal.ark.arkcreditservice.member.domain.MemberRank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberDao extends JpaRepository<MemberRank,Long> {
}
