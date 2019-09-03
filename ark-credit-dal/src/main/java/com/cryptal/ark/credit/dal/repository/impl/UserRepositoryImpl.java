package com.cryptal.ark.credit.dal.repository.impl;

import org.springframework.stereotype.Repository;

import com.cryptal.ark.credit.dal.repository.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Override
    public int[] getUserIds() {
        return new int[0];
    }
}
