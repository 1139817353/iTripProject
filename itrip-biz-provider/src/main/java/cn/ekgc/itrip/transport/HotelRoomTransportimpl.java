package cn.ekgc.itrip.transport;


import cn.ekgc.itrip.pojo.vo.HotelRoom;
import cn.ekgc.itrip.pojo.vo.SearchHotelRoomVO;
import cn.ekgc.itrip.pojo.vo.ValidateRoomStoreVO;
import cn.ekgc.itrip.service.HotelRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

	/**
	 * <b>根据房间主键查询房间信息</b>
	 * @param roomId
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/id")
	public HotelRoom queryHotelRoomById(@RequestParam Long roomId) throws Exception {
		return hotelRoomService.getHotelRoomById(roomId);
	}

	/**
	 * <b>根据查询条件获得可用房间数量</b>
	 * @param validateRoomStoreVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/store")
	public int queryHotelRoomStoreByDate(ValidateRoomStoreVO validateRoomStoreVO) throws Exception {
		return hotelRoomService.getHotelRoomStoreByDate(validateRoomStoreVO);
	}
}
