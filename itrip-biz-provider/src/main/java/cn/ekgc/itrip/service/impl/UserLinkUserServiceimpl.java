package cn.ekgc.itrip.service.impl;

import cn.ekgc.itrip.dao.UserLinkUserDao;
import cn.ekgc.itrip.pojo.entity.UserLinkUser;
import cn.ekgc.itrip.service.UserLinkUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userLinkUserService")
@Transactional
public class UserLinkUserServiceimpl implements UserLinkUserService {
	@Autowired
	private UserLinkUserDao userLinkUserDao;
	/**
	 * <b>根据查询信息查询联系人列表</b>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	public List<UserLinkUser> getUserLinkUserListByQuery(UserLinkUser query) throws Exception {
		List<UserLinkUser> userLinkUserList = userLinkUserDao.findUserListByQuery(query);

		if (userLinkUserList != null){
			return userLinkUserList;
		}
		return new ArrayList<UserLinkUser>();
	}
}
