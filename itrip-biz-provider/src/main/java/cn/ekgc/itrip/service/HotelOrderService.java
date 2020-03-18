package cn.ekgc.itrip.service;

import cn.ekgc.itrip.pojo.vo.RoomStoreVO;
import cn.ekgc.itrip.pojo.vo.ValidateRoomStoreVO;

import java.util.List;

/**
 * <b>查询酒店房间数据业务层接口</b>
 */
public interface HotelOrderService {
	/**
	 * <b>查询酒店房间费用列表</b>
	 * @param validateRoomStoreVO
	 * @return
	 * @throws Exception
	 */
	public List<RoomStoreVO> getFindByRoomPrice(ValidateRoomStoreVO validateRoomStoreVO)throws Exception;
}
