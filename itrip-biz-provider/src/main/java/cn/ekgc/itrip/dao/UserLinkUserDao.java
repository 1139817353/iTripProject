package cn.ekgc.itrip.dao;

import cn.ekgc.itrip.pojo.entity.UserLinkUser;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserLinkUserDao {
	/**
	 * <b>根据查询获得列表信息</b>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	List<UserLinkUser> findUserListByQuery(UserLinkUser query)throws Exception;
}
