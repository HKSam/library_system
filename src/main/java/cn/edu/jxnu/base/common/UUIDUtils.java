package cn.edu.jxnu.base.common;

import java.util.UUID;

/**
 * 生成唯一id工具 用于图书ID

 */
public class UUIDUtils {

	/**
	 * 静态工具方法
	 */
	public static String makeID() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

}
