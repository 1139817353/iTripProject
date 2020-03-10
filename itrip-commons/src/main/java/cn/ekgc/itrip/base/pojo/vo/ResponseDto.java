package cn.ekgc.itrip.base.pojo.vo;

import java.io.Serializable;

/**
 * <b>系统响应数据传输对象</b>
 */

public class ResponseDto<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	private T data;                  //响应结果数据
	private String errorCode;        //错误代码
	private String msg;               //响应结果
    private String success;           //是否成功

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	/**
	 * <b>获得相应数据传输对象-相应成功，并且携带相关数据</b>
	 */
	public static ResponseDto<Object> success(Object data){
		ResponseDto<Object> responseDto = new ResponseDto<>();
		responseDto.setSuccess("true");
		//带回调参数
		responseDto.setData(data);
		return responseDto;
	}

	/**
	 * <b>获得相应数据传输对象-相应成功，不携带相应数据</b>
	 */
	public static ResponseDto<Object> success(){
		ResponseDto<Object> responseDto = new ResponseDto<>();
		responseDto.setSuccess("true");
		return responseDto;
	}

	/**
	 * <b>获得相应数据传输对象-相应失败</b>
	 */
	public static ResponseDto<Object> failure(){
		ResponseDto<Object> responseDto = new ResponseDto<>();
		responseDto.setSuccess("false");
		return responseDto;
	}
	/**
	 * <b>获得相应数据传输对象-响应失败，携带错误信息</b>
	 */
	public static ResponseDto<Object> failure(String msg){
		ResponseDto<Object> responseDto = new ResponseDto<>();
		responseDto.setMsg(msg);
		responseDto.setSuccess("false");
		return responseDto;
	}
}

