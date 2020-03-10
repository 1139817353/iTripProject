package cn.ekgc.itrip.base.enums;

import org.omg.PortableInterceptor.USER_EXCEPTION;

/**
 * <b>用户激活状态枚举对象</b>
 */
public enum UserActivatedEnum {
	USER_ACTIVATED_NO(0),
	USER_ACTIVATED_YES(1)
	;
	private int code;
	private UserActivatedEnum (int code){
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
}
