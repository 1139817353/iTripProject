package cn.ekgc.itrip.transport;

import cn.ekgc.itrip.base.pojo.vo.ResponseDto;
import cn.ekgc.itrip.pojo.vo.RoomStoreVO;
import cn.ekgc.itrip.pojo.vo.ValidateRoomStoreVO;
import cn.ekgc.itrip.service.HotelOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("hotelOrderTransport")
@RequestMapping("/hotelorder")
public class HotelOrderTransportimpl implements HotelOrderTransport {
	@Autowired
	private HotelOrderService hotelOrderService;


	/**
	 * <b>查询酒店房间信息</b>
	 * @param validateRoomStoreVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/getpreorderinfo")
	public List<RoomStoreVO> getFindByQuery(@RequestBody ValidateRoomStoreVO validateRoomStoreVO) throws Exception {
		return hotelOrderService.getFindByRoomPrice(validateRoomStoreVO);
	}

}
