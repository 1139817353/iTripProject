package cn.ekgc.itrip.dao;

import cn.ekgc.itrip.pojo.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <b>爱旅行-用户数据持久层接口</b>
 */
@Repository
public interface UserDao {
	List<User> findListByQuery(User query)throws Exception;

	/**
	 * <b>保存用户信息</b>
	 * @param user
	 * @return
	 * @throws Exception
	 */
	int saveUser(User user)throws Exception;
	/**
	 * <b>修改用户信息</b>
	 * @param user
	 * @return
	 * @throws Exception
	 */
	int updateUser(User user)throws Exception;
}
