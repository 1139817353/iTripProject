package cn.ekgc.itrip.dao;

import cn.ekgc.itrip.pojo.entity.ItripImage;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <b>爱旅行-图片信息数据持久层接口</b>
 */
@Repository
public interface ItripImageDao {
	/**
	 * <b>根据查询条件查询信息</b>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	public List<ItripImage> findListByQuery(ItripImage query)throws Exception;
}
