package cn.ekgc.itrip.transport;

import cn.ekgc.itrip.pojo.entity.LabelDic;
import cn.ekgc.itrip.service.LabelDicService;
import cn.ekgc.itrip.transport.LabelDicTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <b>爱旅行-系统字典信息传输层接口实现类</b>
 */
@RestController("labelDicTransport")
@RequestMapping("/label/trans")
public class LabelDicTransportimpl implements LabelDicTransport {
	@Autowired
	private LabelDicService labelDicService;
	/**
	 * <b>根据查询获得信息列表</b>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/query")
	public List<LabelDic> getListByQuery(LabelDic query) throws Exception {
		return labelDicService.getListByQuery(query);
	}
}
