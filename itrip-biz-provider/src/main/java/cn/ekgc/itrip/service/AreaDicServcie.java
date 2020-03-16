package cn.ekgc.itrip.service;

import cn.ekgc.itrip.pojo.entity.AreaDic;

import java.util.List;

/**
 * <b>爱旅行-区域字典信息业务层</b>
 */
public interface AreaDicServcie {
	/**
	 * <b>根据查询获得信息列表</b>
	 * @param query
	 * @return
	 */

	List<AreaDic> getListByQuery(AreaDic query) throws Exception;
}
