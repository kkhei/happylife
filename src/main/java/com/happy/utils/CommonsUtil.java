package com.happy.utils;

import java.util.UUID;
/**
 * 
 * @author zhaohappy
 * @time 2019年12月12日
 * @description 公共方法
 */
public class CommonsUtil {
	/**
	 * 获取uuid
	 * @return
	 */
	public String getUuid() {
		UUID randomUUID = UUID.randomUUID();
		return randomUUID.toString();
	}
}
