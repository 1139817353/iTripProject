package cn.ekgc.itrip.transport;

import cn.ekgc.itrip.pojo.entity.ItripImage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * <b>爱旅行-图片传输层接口</b>
 */
@FeignClient(name ="itrip-biz-provider")
@RequestMapping("/img/trans")
public interface ItripImageTransport {
	/**
	 * <b>根据查询条件查询信息</b>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	 @PostMapping(value = "/list")
	 List<ItripImage> getItripImageListByQuery(ItripImage query)throws Exception;
}
