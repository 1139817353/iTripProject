package cn.ekgc.itrip.controller;

import cn.ekgc.itrip.base.enums.UserActivatedEnum;
import cn.ekgc.itrip.base.enums.UserTypeEnum;
import cn.ekgc.itrip.base.pojo.vo.ResponseDto;
import cn.ekgc.itrip.pojo.entity.User;
import cn.ekgc.itrip.pojo.vo.UserVO;
import cn.ekgc.itrip.transport.UserTransport;
import cn.ekgc.itrip.util.JWTUtil;
import cn.ekgc.itrip.util.MD5Util;
import cn.ekgc.itrip.util.RegValidationUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <b>爱旅行-认证控制模块</b>
 */
@RestController("authController")
@RequestMapping("/auth/api")
public class AuthController {
	@Autowired
	private UserTransport userTransport;
	@Autowired
	private HttpServletResponse response;
	/**
	 * <b>用户验证-电子邮件</b>
	 * @param name
	 * @return
	 * @throws Exception
	 */
	@GetMapping(value = "/ckusr")
    public ResponseDto<Object> checkUserEmailForRegistry(String name) throws Exception{
      //校验用户的电子邮件
      if(RegValidationUtil.validateEmail(name)){
	      User query = new User();
	      query.setUserCode(name);
	      //进行查询
	      List<User> userList = userTransport.getListByQuery(query);
	      if(userList == null || userList.size() == 0){
	      	//可用邮箱地址
		      return ResponseDto.success();

	      }
      }

       return ResponseDto.failure("该邮箱已被注册");
    }
	/**
	 * <b>使用电子邮件注册用户信息</b>
	 */
      @PostMapping(value = "/doregister")
	public ResponseDto<Object> registryUser(UserVO userVO)throws Exception{
       //教研用户所制定信息是否有效
	      if(RegValidationUtil.validateEmail(userVO.getUserCode()) && userVO.getUserPassword() !=null && !"".equals(userVO.getUserPassword())){
            //进行唯一性校验
		      User query = new User();
		      query.setUserCode(userVO.getUserCode());
		      List<User> userList = userTransport.getListByQuery(query);
		      if (userList == null || userList.size() <= 0){
			      //对于密码进行MD5加密
			      userVO.setUserPassword(MD5Util.encrypt(userVO.getUserPassword()));
			      //将用户的UserVO转换成User对象
			      User user = new User();
			      BeanUtils.copyProperties(userVO,user);
			      //使用传输层，远程调用生产者进行用户信息注册工作
			      //当调用该方法的时候，用户属于自主注册
			      user.setUserType(UserTypeEnum.USER_TYPE_REG.getCode());
			      //将激活状态设置为未激活
			      user.setActivated(UserActivatedEnum.USER_ACTIVATED_NO.getCode());
			      boolean flag = userTransport.saveUser(user);
			      if(flag){
				      //注册成功
				      return ResponseDto.success();
			      }
		      }

	      }

      	return ResponseDto.failure("注册失败");
}

	/**
	 * <b>是用手机号注册用户</b>
	 * @param userVO
	 * @return
	 * @throws Exception
	 */
     @PostMapping(value = "/registerbyphone")
     public ResponseDto<Object> registryByCellphone(@RequestBody UserVO userVO)throws Exception{
	     //教研用户所制定信息是否有效
	     if(RegValidationUtil.validatecellphone(userVO.getUserCode()) && userVO.getUserPassword() != null && !"".equals(userVO.getUserPassword())){
		    //进行唯一性校验
		     User query = new User();
		     query.setUserCode(userVO.getUserCode());
		     List<User> userList = userTransport.getListByQuery(query);
		     if (userList == null && userList.size() == 0){
		     	//此时的手机号码未注册

			     //对于密码进行MD5加密
			     userVO.setUserPassword(MD5Util.encrypt(userVO.getUserPassword()));
			     //将用户的UserVO转换成User对象
			     User user = new User();
			     BeanUtils.copyProperties(userVO,user);
			     //使用传输层，远程调用生产者进行用户信息注册工作
			     //当调用该方法的时候，用户属于自主注册
			     user.setUserType(UserTypeEnum.USER_TYPE_REG.getCode());
			     //将激活状态设置为未激活
			     user.setActivated(UserActivatedEnum.USER_ACTIVATED_NO.getCode());
			     boolean flag = userTransport.saveUser(user);
			     if(flag){
				     //注册成功
				     return ResponseDto.success();
			     }
		     }
	     return  ResponseDto.failure("该用户手机号已被注册");
     }

	     return ResponseDto.failure("注册失败");
     }

	/**
	 * <b>激活注册用户-邮箱</b>
	 * @param user
	 * @param code
	 * @return
	 * @throws Exception
	 */
      @PutMapping(value = "/activate")
      public ResponseDto<Object> activeUser(String user,String code)throws Exception{
      	//校验用户所给定的user和code有效
	      if(user != null && !"".equals(user.trim()) && code != null && !"".equals(code)){
	      	//通过user在Redis中查询相应的code
		      String  activeCode = userTransport.getActiveCodeByUserCode(user);
		      //比较两个code是否相同
		      if(code.equals(activeCode)){
		      	//修改用户激活状态
			      User updateUser = new User();
			      updateUser.setUserCode(user);
			      updateUser.setActivated(UserActivatedEnum.USER_ACTIVATED_YES.getCode());
			      //在数据库中更新用户数据
			      userTransport.updateUser(updateUser);
			      return ResponseDto.success();
		      }
		      return ResponseDto.failure("激活码不正确");
	      }
	      //通过user在Redis中查询相应的code
	      //比较两个code是否相同
	      return ResponseDto.failure("激活失败");
      }

	/**
	 * <b>激活注册用户-手机号码</b>
	 * @param user
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@PutMapping(value = "/validatephone")
	public ResponseDto<Object> activeUserByCellphone(String user,String code)throws Exception{
		//校验用户所给定的user和code有效
		if(user != null && !"".equals(user.trim()) && code != null && !"".equals(code)){
			//通过user在Redis中查询相应的code
			String  activeCode = userTransport.getActiveCodeByUserCode(user);
			//比较两个code是否相同
			if(code.equals(activeCode)){
				//修改用户激活状态
				User updateUser = new User();
				updateUser.setUserCode(user);
				updateUser.setActivated(UserActivatedEnum.USER_ACTIVATED_YES.getCode());
				//在数据库中更新用户数据
				userTransport.updateUser(updateUser);
				return ResponseDto.success();
			}
			return ResponseDto.failure("激活码不正确");
		}
		//通过user在Redis中查询相应的code
		//比较两个code是否相同
		return ResponseDto.failure("激活失败");
	}

	/**
	 * <b>使用cellphone/email和password登录系统</b>
	 * @param name
	 * @param password
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/dologin")
	public ResponseDto<Object> loginUser(String name, String password) throws Exception {
		if (name != null && !"".equals(name.trim())
				&& password != null && !"".equals(password.trim())) {
			// 通过登陆用户名查找相关信息，在比较密码是否相同
			User query = new User();
			query.setUserCode(name);
			// 查找获得相应结果
			List<User> userList = userTransport.getListByQuery(query);
			if (userList != null && userList.size() > 0) {
				User user = userList.get(0);
				// 比较密码是否相同
				if (user.getUserPassword().equals(MD5Util.encrypt(password))) {
					if (user.getActivated() == UserActivatedEnum.USER_ACTIVATED_YES.getCode()) {
						// 登陆成功，按照相应的技术，生成一个Token令牌，以Cookie形式交给浏览器，
						// 每当浏览器在访问其他服务器的时候，都会携带该信息，如果需要校验该用户是否登陆，
						// 只需要校验该Token是否是按照系统规则生成的即可。
						// 在Java当中，Token技术使用了JWT（Java Web Token）来完成
						// 使用当前登陆用户的id生成Token信息
						String token = JWTUtil.createToken(user.getId());
						// 将Token随着相应交给浏览器
						response.setHeader("Authorization", token);
						return ResponseDto.success(token);
					} else {
						return ResponseDto.failure("该用户未激活");
					}
				} else {
					return ResponseDto.failure("登陆密码错误");
				}
			} else {
				return ResponseDto.failure("该用户未注册");
			}
		} else {
			return ResponseDto.failure("请填写登陆信息");
		}
	}
}
