package cn.ekgc.itrip.transport;


import cn.ekgc.itrip.pojo.vo.HotelRoom;
import cn.ekgc.itrip.pojo.vo.SearchHotelRoomVO;
import cn.ekgc.itrip.service.HotelRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <b>爱旅行-酒店房间模块传输层接口</b>
 */
@RestController("hotelRoomTransport")
@RequestMapping("/hotelroom/trans")
public class HotelRoomTransportimpl implements HotelRoomTransport {
	@Autowired
	private HotelRoomService hotelRoomService;
	/**
	 * <b>查询酒店列表-此刻可以预定的房间列表</b>
	 * @param searchHotelRoomVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/queryhotelroombyhotel")
	public List<HotelRoom> queryHotelRoomByHotel(@RequestBody SearchHotelRoomVO searchHotelRoomVO) throws Exception {

		return hotelRoomService.queryHotelRoomByHotel(searchHotelRoomVO);
	}
}
