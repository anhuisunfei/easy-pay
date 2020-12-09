package com.payment.common.util;

import com.payment.common.constant.MsgConstant;
import com.payment.common.constant.SystemConstant;
import com.payment.common.model.Result;

/**
 * 通用工具类
 * 爪哇笔记：https://blog.52itstyle.vip
 */
public class CommonUtils {

	/**
	 * 对象是否为空
	 *
	 * @param obj
	 * @return
	 */
	public static boolean isNullOrEmpty(Object obj) {
		if (obj == null) {
			return true;
		}
		return false;
	}


	/**
	 * 查询详情提示
	 * @param data
	 * @return
	 */
	public static Result msg(Object data) {
		if (isNullOrEmpty(data)) {
			return Result.error(MsgConstant.MSG_INIT_FORM);
		}
		return Result.ok(data);
	}

	/**
	 * 返回数据
	 * 
	 * @param data
	 * @return
	 */
	public static Result msgNotCheckNull(Object data) {
		return Result.ok().put(SystemConstant.DATA_ROWS, data);
	}

}
