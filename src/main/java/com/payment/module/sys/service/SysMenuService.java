package com.payment.module.sys.service;

import com.payment.common.model.Result;
import com.payment.module.sys.entity.SysMenu;

import java.util.List;

public interface SysMenuService {

    Result list(SysMenu menu);

    List<SysMenu> select(Long parentId);

    Result delete(Long menuId);

    List<SysMenu> getByUserId(Long userId);

    Result drop(Long parentId, Long menuId);
}
