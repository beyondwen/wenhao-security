package com.wenhao.security.wenhaosecuritydemo.web.controller.async;

import java.util.UUID;
/**
 * uuid工具类
 * @author wh
 *
 */
public class UUIDUtils {
	//生成32位UUID
	public static String getUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

}
