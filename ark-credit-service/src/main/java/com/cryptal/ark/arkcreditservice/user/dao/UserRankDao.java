package com.cryptal.ark.arkcreditservice.user.dao;

import com.cryptal.ark.arkcreditservice.user.domain.UserRank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRankDao extends JpaRepository<UserRank,Long> {
    List<UserRank> findByUserId(Long userId);
}
