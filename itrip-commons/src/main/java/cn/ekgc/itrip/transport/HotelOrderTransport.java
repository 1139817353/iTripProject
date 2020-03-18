package cn.ekgc.itrip.transport;

import cn.ekgc.itrip.base.pojo.vo.ResponseDto;
import cn.ekgc.itrip.pojo.vo.RoomStoreVO;
import cn.ekgc.itrip.pojo.vo.ValidateRoomStoreVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * <b>查询酒店房间数据传输层</b>
 */
@FeignClient(name ="itrip-biz-provider")
@RequestMapping("/hotelorder")
public interface HotelOrderTransport {
	/**
	 * <b>查询酒店房间信息</b>
	 * @param validateRoomStoreVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/getpreorderinfo")
	List<RoomStoreVO> getFindByQuery(@RequestBody ValidateRoomStoreVO validateRoomStoreVO)throws Exception;

}
