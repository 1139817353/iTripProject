package cn.ekgc.itrip.dao;

import cn.ekgc.itrip.pojo.entity.LabelDic;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <b>爱旅行-系统字典信息数据持久层</b>
 */
@Repository
public interface LabelDicDao {
	/**
	 * <b>按照查询条件查询信息列表</b>
	 */
	public List<LabelDic> findListByQuery(LabelDic query) throws Exception;
}
