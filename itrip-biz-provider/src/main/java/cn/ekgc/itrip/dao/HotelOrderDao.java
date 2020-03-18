package cn.ekgc.itrip.dao;

import cn.ekgc.itrip.pojo.vo.RoomStoreVO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <b>酒店订单数据持久层</b>
 */
@Repository
public interface HotelOrderDao {
	/**
	 * <b>根据查询条件查询未支付和已支付的订单中所下单的房间总数</b>
	 * @param queryMap
	 * @return
	 * @throws Exception
	 */
   Integer findOrderRoomCountByQuery(Map<String,Object> queryMap) throws Exception;

	/**
	 * <b>查询房间费用</b>
	 * @param roomStoreVO
	 * @return
	 * @throws Exception
	 */
	List<RoomStoreVO> findgetPreOrderInfo(RoomStoreVO roomStoreVO)throws Exception;
}
