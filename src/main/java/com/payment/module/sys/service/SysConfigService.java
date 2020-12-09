package com.payment.module.sys.service;

import com.payment.common.model.Result;
import com.payment.module.sys.entity.SysConfig;

public interface SysConfigService {

    Result save(SysConfig config);

    Result get(Long id);

    Result delete(Long id);

    Result list(SysConfig config);
}
