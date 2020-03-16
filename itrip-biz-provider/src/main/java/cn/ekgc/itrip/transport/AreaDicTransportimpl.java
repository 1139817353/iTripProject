package cn.ekgc.itrip.transport;

import cn.ekgc.itrip.pojo.entity.AreaDic;
import cn.ekgc.itrip.service.AreaDicServcie;
import cn.ekgc.itrip.transport.AreaDicTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <b>爱旅行-区域字典信息传输层接口实现类</b>
 */
@RestController("areaDicTransport")
@RequestMapping("/area/trans")
public class AreaDicTransportimpl implements AreaDicTransport {
    @Autowired
	private AreaDicServcie areaDicServcie;
	/**
	 * <b>根据查询获得信息列表</b>
	 * @param query
	 * @return
	 */
	@PostMapping(value = "/query")
    public List<AreaDic> getListByQuery(AreaDic query) throws  Exception{
		return areaDicServcie.getListByQuery(query);
	}
}
