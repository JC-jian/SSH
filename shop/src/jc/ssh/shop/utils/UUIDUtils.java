package jc.ssh.shop.utils;

import java.util.UUID;

/**
 * 生成激活码
 * @author v-Jc
 *
 */
public class UUIDUtils {
	public static String getUUID(){
		return UUID.randomUUID().toString().replace("-","");
	}

}
