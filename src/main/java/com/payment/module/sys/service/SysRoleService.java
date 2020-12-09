package com.payment.module.sys.service;

import com.payment.common.model.Result;
import com.payment.module.sys.entity.SysRole;

public interface SysRoleService {

    Result list(SysRole role);

    Result select();

    Result save(SysRole role);

    Result delete(Long roleId);

    Result getMenu(Long roleId);

    Result saveMenu(SysRole role);

    Result getOrg(Long roleId);

    Result saveOrg(SysRole role);

}
