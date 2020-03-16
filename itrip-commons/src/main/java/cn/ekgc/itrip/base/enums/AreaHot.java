package cn.ekgc.itrip.base.enums;

/**
 * <b>是否是热门城市枚举信息</b>
 */
public enum AreaHot {
	AREA_HOT_YES(1),
	AREA_HOT_NO(0)
	;
	private int code;
	private AreaHot (int code){
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
}
