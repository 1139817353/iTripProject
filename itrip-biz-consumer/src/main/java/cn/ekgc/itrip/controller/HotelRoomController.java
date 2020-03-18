package cn.ekgc.itrip.controller;

import cn.ekgc.itrip.base.controller.BaseController;
import cn.ekgc.itrip.base.enums.ImageTypeEnum;
import cn.ekgc.itrip.base.pojo.vo.ResponseDto;
import cn.ekgc.itrip.pojo.entity.ItripImage;
import cn.ekgc.itrip.pojo.entity.LabelDic;
import cn.ekgc.itrip.pojo.vo.HotelRoom;
import cn.ekgc.itrip.pojo.vo.SearchHotelRoomVO;
import cn.ekgc.itrip.transport.HotelRoomTransport;
import cn.ekgc.itrip.transport.ItripImageTransport;
import cn.ekgc.itrip.transport.LabelDicTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
	@Autowired
	private ItripImageTransport itripImageTransport;
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
	/**
	 * <b>根据targetId查询酒店图片（type=1）</b>
	 * @param targetId
	 * @return
	 * @throws Exception
	 */
	@GetMapping(value = "/getimg/{targetId}")
	public ResponseDto<Object> getImgForHotel(@PathVariable("targetId") Long targetId)throws Exception{
		ItripImage query = new ItripImage();
		query.setTargetId(targetId);
		//强制类型转换成String类型
		query.setType(String.valueOf(ImageTypeEnum.IMAGE_TYPE_ROOM.getCode()));

		List<ItripImage> itripImageList = itripImageTransport.getItripImageListByQuery(query);


		return ResponseDto.success(itripImageList);
	}
}
