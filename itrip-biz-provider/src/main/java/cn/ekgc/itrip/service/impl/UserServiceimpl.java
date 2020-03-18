package cn.ekgc.itrip.service.impl;

		import cn.ekgc.itrip.dao.UserDao;
		import cn.ekgc.itrip.pojo.entity.User;
		import cn.ekgc.itrip.service.UserService;
		import cn.ekgc.itrip.util.ActiveCodeUtil;
		import cn.ekgc.itrip.util.MailSenderUtil;
		import cn.ekgc.itrip.util.RegValidationUtil;
		import cn.ekgc.itrip.util.SmsSenderUtil;
		import org.springframework.beans.factory.annotation.Autowired;
		import org.springframework.data.redis.core.StringRedisTemplate;
		import org.springframework.stereotype.Service;
		import org.springframework.transaction.annotation.Transactional;

		import java.util.Date;
		import java.util.List;
		import java.util.concurrent.TimeUnit;

@Service("userService")
@Transactional
public class UserServiceimpl  implements UserService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private MailSenderUtil mailSenderUtil;
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
    @Autowired
	private SmsSenderUtil smsSenderUtil;
	/**
	 * <b>根据查询对象查询用户信息</b>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	public List<User> getListByQuery(User query) throws Exception {
		//调用数据持久层查询列表

		return userDao.findListByQuery(query);
	}

	/**
	 * <b>保存用户信息</b>
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public boolean saveUser(User user) throws Exception {
		//设定用户添加时间
		user.setCreationDate(new Date());
		//使用数据持久层保存用户信息
		int count = userDao.saveUser(user);
		if(count > 0 ){

			//产生激活码，将激活码保存到HttpSession中
			String activeCode = ActiveCodeUtil.createActiveCode();
			//使用StringRedisTemlate将验证码进行保存，key位影虎的email地址，value则是激活码
			stringRedisTemplate.opsForValue().set(user.getUserCode(),activeCode);
			//设置存储于redis数据的存活时间
			stringRedisTemplate.expire(user.getUserCode(),30, TimeUnit.MINUTES);
			//判断此时用户注册使用的是手机号还是邮箱地址
			if (RegValidationUtil.validateEmail(user.getUserCode())){
				//通过发送邮件，将激活码发送给用户
				return mailSenderUtil.sendActiveCodeMail(user.getUserCode(),activeCode);
			}else if(RegValidationUtil.validatecellphone(user.getUserCode())){
				//使用手机号码将激活码发送用户
                 return smsSenderUtil.sendSms(user.getUserCode(),activeCode);

			}

		}
		return false;
	}

	/**
	 * <b>通过userCode在Redis中查询对应的激活码</b>
	 * @param userCode
	 * @return
	 * @throws Exception
	 */
	public String getActiveCodeByUserCode(String userCode) throws Exception {
		//通过Redis查询对应的激活码
		String activeCode = stringRedisTemplate.opsForValue().get(userCode);
		return activeCode;
	}

	/**
	 * <b>修改用户信息</b>
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public boolean updateUser(User user) throws Exception {
		int count = userDao.updateUser(user);
		if (count > 0){
			return true;
		}
		return false;
	}
}
