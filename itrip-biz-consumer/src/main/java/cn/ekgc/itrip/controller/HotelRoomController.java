package cn.ekgc.itrip.controller;

import cn.ekgc.itrip.base.controller.BaseController;
import cn.ekgc.itrip.base.pojo.vo.ResponseDto;
import cn.ekgc.itrip.pojo.entity.LabelDic;
import cn.ekgc.itrip.pojo.vo.HotelRoom;
import cn.ekgc.itrip.pojo.vo.SearchHotelRoomVO;
import cn.ekgc.itrip.transport.HotelRoomTransport;
import cn.ekgc.itrip.transport.LabelDicTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>爱旅行-酒店房间控制层</b>
 */
@RestController("hotelRoomController")
@RequestMapping("/biz/api/hotelroom")
public class HotelRoomController extends BaseController {
	@Autowired
	private LabelDicTransport  labelDicTransport;
	@Autowired
	private HotelRoomTransport hotelRoomTransport;
	/**
	 * <b>查询酒店列表-此刻可以预定的房间列表</b>
	 * @param searchHotelRoomVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/queryhotelroombyhotel")
	public ResponseDto<Object> queryHotelRoombyHotel(SearchHotelRoomVO searchHotelRoomVO)throws Exception{
        List<List<HotelRoom>> resultList = new ArrayList<List<HotelRoom>>();
         //查询可用酒店列表
		List<HotelRoom> hotelRoomList = hotelRoomTransport.queryHotelRoomByHotel(searchHotelRoomVO);
		if (hotelRoomList != null && hotelRoomList.size() > 0) {
			for (HotelRoom hotelRoom : hotelRoomList){
				List<HotelRoom> list = new ArrayList<HotelRoom>();
				list.add(hotelRoom);
				resultList.add(list);
			}
		}
		return ResponseDto.success(hotelRoomList);
	}

	/**
	 * <b>查询酒店房间床型列表</b>
	 * @return
	 * @throws Exception
	 */
	@GetMapping(value = "/queryhotelroombed")
     public ResponseDto<Object> queryHotelRoombed() throws Exception{
       //封装查询对象
	     LabelDic query = new LabelDic();
	     //查询所有床型
	     query.setParentId(1L);
	     return ResponseDto.success(labelDicTransport.getListByQuery(query));
     }
}
