package cn.ekgc.itrip.util;


/**
 * <b>使用正则验证工具类</b>
 */
public class RegValidationUtil {
	//设置电子邮件格式
	private static final String emailRegEx = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
	//设置手机号码格式
	private static final String cellphoneRegEx ="1\\d{10}";
	/**
	 * <b>判断电子邮件信息</b>
	 * @param email
	 * @return
	 * @throws Exception
	 */
    public static boolean validateEmail(String email){
    	//判断此时的email地址不能喂null，并且也不是空字符串
	    if(email != null&& !"".equals(email)){
	    	//如果格式一致返回email
	    	return email.matches(emailRegEx);
	    }
	    return false;
    }
	public static void main(String[] args) {
		String email = "lang@112.com";
		System.out.println(validateEmail(email));
	}
	/**
	 * <b>判断手机号码信息</b>
	 * @param cellphone
	 * @return
	 * @throws Exception
	 */
	public static boolean validatecellphone(String cellphone){
		//判断此时的email地址不能喂null，并且也不是空字符串
		if(cellphone != null&& !"".equals(cellphone)){
			//如果格式一致返回email
			return cellphone.matches(cellphoneRegEx);
		}
		return false;
	}
}

