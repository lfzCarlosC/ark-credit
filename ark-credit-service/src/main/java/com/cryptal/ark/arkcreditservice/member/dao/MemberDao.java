package com.cryptal.ark.arkcreditservice.member.dao;

import com.cryptal.ark.arkcreditservice.member.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberDao extends JpaRepository<MemberEntity,Long> {
}
