package com.cryptal.ark.arkcreditservice.role.service;

import com.cryptal.ark.arkcreditservice.role.domain.Role;

public interface UserRoleService {

    public Role getRoleByUserId(int userId);

    public Role updagradeRole(int userId);
}
