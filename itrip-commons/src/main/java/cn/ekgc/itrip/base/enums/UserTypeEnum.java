package cn.ekgc.itrip.base.enums;

import org.omg.PortableInterceptor.USER_EXCEPTION;

/**
 * <b>爱旅行-用户类型枚举信息</b>
 */
public enum UserTypeEnum {
	USER_TYPE_REG(0),
	USER_TYPE_WX(1),
	USER_TYPE_QQ(2),
	USER_TYPE_WB(3)
	;
	private int code;
	private UserTypeEnum (int code){
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
}
