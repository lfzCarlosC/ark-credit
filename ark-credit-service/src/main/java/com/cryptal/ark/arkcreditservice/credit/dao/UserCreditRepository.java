package com.cryptal.ark.arkcreditservice.credit.dao;

import com.cryptal.ark.arkcreditservice.credit.domain.UserCredit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCreditRepository extends JpaRepository<UserCredit,Long> {
    UserCredit findByUserId(Long invitedUserId);
}
