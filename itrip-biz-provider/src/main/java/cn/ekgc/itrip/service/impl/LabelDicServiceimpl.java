package cn.ekgc.itrip.service.impl;

import cn.ekgc.itrip.dao.LabelDicDao;
import cn.ekgc.itrip.pojo.entity.LabelDic;
import cn.ekgc.itrip.service.LabelDicService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;



/**
 * <b>爱旅行-系统字典信息业务层接口实现类</b>
 */
public class LabelDicServiceimpl implements LabelDicService {
    @Autowired
	private LabelDicDao labelDicDao;

	/**
	 * <b>根据查询获得信息列表</b>
	 * @param query
	 * @return
	 * @throws Exception
	 */

	public List<LabelDic> getListByQuery(LabelDic query) throws Exception {
		//通过数据库持久层查询结果
		List<LabelDic> labelDicList = labelDicDao.findListByQuery(query);
		if (labelDicList != null){
			return labelDicList;
		}
		return new ArrayList<LabelDic>();
	}
}
