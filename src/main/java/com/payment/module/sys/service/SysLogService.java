package com.payment.module.sys.service;

import com.payment.common.model.Result;
import com.payment.module.sys.entity.SysLog;

public interface SysLogService {

    Result list(SysLog log);
}
