package cn.ekgc.itrip.transport;

import cn.ekgc.itrip.pojo.entity.ItripImage;
import cn.ekgc.itrip.service.ItripImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <b>爱旅行-图片传输层接口实现类</b>
 */
@RestController("itripImageTransport")
@RequestMapping("/img/trans")
public class ItripImageTransportimpl  implements ItripImageTransport{
	@Autowired
	private ItripImageService itripImageService;
	/**
	 * <b>根据查询条件查询信息</b>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/list")
	public List<ItripImage> getItripImageListByQuery(ItripImage query) throws Exception {

		return itripImageService.getImageListByQuery(query);
	}
}
