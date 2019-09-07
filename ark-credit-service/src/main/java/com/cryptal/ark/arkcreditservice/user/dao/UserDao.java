package com.cryptal.ark.arkcreditservice.user.dao;

import com.cryptal.ark.arkcreditservice.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Long> {
}
