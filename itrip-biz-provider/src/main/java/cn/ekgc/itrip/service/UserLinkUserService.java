package cn.ekgc.itrip.service;

import cn.ekgc.itrip.pojo.entity.UserLinkUser;

import java.util.List;

public interface UserLinkUserService {

	/**
	 * <b>根据查询信息获得查询联系人列表</b>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	List<UserLinkUser> getUserLinkUserListByQuery(UserLinkUser query)throws Exception;
}
