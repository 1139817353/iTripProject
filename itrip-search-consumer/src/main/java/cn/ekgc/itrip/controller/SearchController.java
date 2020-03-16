package cn.ekgc.itrip.controller;

import cn.ekgc.itrip.base.controller.BaseController;
import cn.ekgc.itrip.base.pojo.vo.ResponseDto;
import cn.ekgc.itrip.pojo.vo.HotelVO;
import cn.ekgc.itrip.pojo.vo.SearchHotCityVO;
import cn.ekgc.itrip.transport.HotelTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <b>爱旅行-搜索模块控制器</b>
 */
@RestController("searchController")
@RequestMapping("/search/api")
public class SearchController extends BaseController {
   @Autowired
	private HotelTransport hotelTransport;
   public ResponseDto<Object> searchItripHotelListByHotCity(@RequestBody SearchHotCityVO queryVO)throws Exception{
	   List<HotelVO> hotelList = hotelTransport.searchItripHotelListByHotCity(queryVO);
   	return ResponseDto.success(hotelList);
   }
}
