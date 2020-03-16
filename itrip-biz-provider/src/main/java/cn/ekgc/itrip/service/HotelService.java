package cn.ekgc.itrip.service;

import cn.ekgc.itrip.pojo.entity.Hotel;
import cn.ekgc.itrip.pojo.vo.HotelVO;
import cn.ekgc.itrip.pojo.vo.SearchHotCityVO;

import java.util.List;

/**
 * <b>爱旅行-酒店模块业务层接口</b>
 */
public interface HotelService {
	/**
	 * <b>根据热门城市查询酒店</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	List<HotelVO> searchItripHotelListByHotCity(SearchHotCityVO queryVO)throws Exception;

	/**
	 * <b>根据主键查询对象信息</b>
	 * @param hotelId
	 * @return
	 * @throws Exception
	 */
	Hotel getHotelById(Long hotelId)throws Exception;
}
