package cn.ekgc.itrip.util;

import java.util.Random;

/**
 * <b>激活码工具类</b>
 */
public class ActiveCodeUtil {
	public static String createActiveCode(){
		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		for(int i = 0; i< 6;i++){
			sb.append(random.nextInt(10));

		}
		return sb.toString();
	}
}
