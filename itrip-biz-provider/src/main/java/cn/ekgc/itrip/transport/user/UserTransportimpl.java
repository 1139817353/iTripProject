package cn.ekgc.itrip.transport.user;

import cn.ekgc.itrip.dao.UserDao;
import cn.ekgc.itrip.pojo.entity.User;
import cn.ekgc.itrip.service.UserService;
import cn.ekgc.itrip.transport.UserTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
@RestController("userTransport")
@RequestMapping("/user/trans")
public class UserTransportimpl implements UserTransport {
	@Autowired
	private UserService userService;
	/**
	 * <b>根据查询信息查询用户信息列表</b>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/list")
	public List<User> getListByQuery(@RequestBody User query) throws Exception {

		return userService.getListByQuery(query);
	}

	/**
	 * <b>保存用户信息</b>
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/save")
	public boolean saveUser(@RequestBody User user) throws Exception {
		return userService.saveUser(user);
	}

	/**
	 * <b>通过userCode在Redis中查询对应的激活码</b>
	 * @param userCode
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/activeCode")
	public String getActiveCodeByUserCode(String userCode) throws Exception {
		return userService.getActiveCodeByUserCode(userCode);
	}

	/**
	 * <b>修改用户信息</b>
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/updateUser")
	public boolean updateUser(@RequestBody User user) throws Exception {
		return userService.updateUser(user);
	}
}
