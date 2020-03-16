package cn.ekgc.itrip.dao;

import cn.ekgc.itrip.pojo.entity.AreaDic;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <b>爱旅行-酒店区域信息数据持久层接口</b>
 */
@Repository
public interface AreaDicDao {
	/**
	 * <b>按照条件查询信息列表</b>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	public List<AreaDic> findListByQuery(AreaDic query) throws  Exception;
}
