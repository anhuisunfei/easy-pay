package com.payment.module.sys.service;

import com.payment.common.model.Result;
import com.payment.module.sys.entity.SysOrg;

public interface SysOrgService {

    Result list(SysOrg org);

    Result select(Long parentId);

    Result save(SysOrg org);

    Result delete(Long orgId);

}
