package cn.ekgc.itrip.transport;

import cn.ekgc.itrip.pojo.entity.Hotel;
import cn.ekgc.itrip.pojo.vo.HotelVO;
import cn.ekgc.itrip.pojo.vo.SearchHotCityVO;
import cn.ekgc.itrip.service.HotelService;
import cn.ekgc.itrip.transport.HotelTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <b>爱旅行-酒店模块传输层接口实现类</b>
 */
@RestController("hotelTransport")
@RequestMapping("hotel/trans")
public class HotelTransportimpl implements HotelTransport {
	@Autowired
	private HotelService hotelService;
	/**
	 * <b>根据热门城市查询酒店</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/searchItripHotelListByHotCity")
	public List<HotelVO> searchItripHotelListByHotCity(SearchHotCityVO queryVO) throws Exception {
		return hotelService.searchItripHotelListByHotCity(queryVO);
	}

	/**
	 * <b>根据主键查询对象信息</b>
	 * @param hotelId
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/id")
	public Hotel getHotelById(@RequestParam Long hotelId) throws Exception {
		return hotelService.getHotelById(hotelId);
	}
}
