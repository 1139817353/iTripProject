package cn.ekgc.itrip.util;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class HotelOrderNoCreator {
	public static String createHotelOrderNo(Long hotelId,Long roomId)throws Exception{
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		//增加 HotelId
		sb.append(hotelId);
		//增加roomId
		sb.append(roomId);
		//获得当前时间，进行格式化
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmSSS");
		sb.append(dateFormat.format(new Date()));
		//新增随机数
		sb. append(random.nextInt(10));
		//对于该结果进行MD5
		String result= MD5Util.encrypt(sb.toString());

		return result;

	}

	public static void main(String[] args) throws Exception {
		System.out.println(createHotelOrderNo(1L,1L));
	}

}
