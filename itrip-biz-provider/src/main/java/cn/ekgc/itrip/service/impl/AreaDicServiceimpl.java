package cn.ekgc.itrip.service.impl;

import cn.ekgc.itrip.dao.AreaDicDao;
import cn.ekgc.itrip.pojo.entity.AreaDic;
import cn.ekgc.itrip.service.AreaDicServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * <b>爱旅行-区域字典信息业务实现类</b>
 */
@Service("areaDicService")
@Transactional
public class AreaDicServiceimpl implements AreaDicServcie {
    @Autowired
	private AreaDicDao areaDicDao;

	/**
	 * <b>根据查询获得信息列表</b>
	 * @param query
	 * @return
	 */
	public List<AreaDic> getListByQuery(AreaDic query) throws Exception {
		//通过数据持久层查询结果
		List<AreaDic> areaDicList = areaDicDao.findListByQuery(query);
		if(areaDicList != null){
			return areaDicList;
		}
		return new ArrayList<AreaDic>();
	}
}
