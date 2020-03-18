package cn.ekgc.itrip.controller;

import cn.ekgc.itrip.base.controller.BaseController;
import cn.ekgc.itrip.base.pojo.vo.ResponseDto;
import cn.ekgc.itrip.pojo.vo.RoomStoreVO;
import cn.ekgc.itrip.pojo.vo.ValidateRoomStoreVO;
import cn.ekgc.itrip.transport.HotelOrderTransport;
import jdk.nashorn.internal.ir.ReturnNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.reactive.Response;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <b>爱旅行-主业务酒店订单模块控制器</b>
 */
@RestController("hotelOrderController")
@RequestMapping("/biz/api/hotelorder")
public class HotelOrderController extends BaseController {
	@Autowired
	private HotelOrderTransport hotelOrderTransport;
	/**
	 * <b>生成订单前，获得预定信息</b>
	 * @param validateRoomStoreVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/getpreorderinfo")
	public ResponseDto<Object> getPreOrderInfo(ValidateRoomStoreVO validateRoomStoreVO)throws Exception{
		List<RoomStoreVO> queryList = hotelOrderTransport.getFindByQuery(validateRoomStoreVO);
		return ResponseDto.success(queryList);
	}
}
