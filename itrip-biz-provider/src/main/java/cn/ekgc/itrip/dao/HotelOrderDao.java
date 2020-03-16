package cn.ekgc.itrip.dao;

import cn.ekgc.itrip.pojo.entity.Hotel;
import cn.ekgc.itrip.pojo.entity.HotelOrder;
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
}
