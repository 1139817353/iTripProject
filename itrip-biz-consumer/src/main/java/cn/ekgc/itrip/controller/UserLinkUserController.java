package cn.ekgc.itrip.controller;

import cn.ekgc.itrip.base.controller.BaseController;
import cn.ekgc.itrip.base.pojo.vo.ResponseDto;
import cn.ekgc.itrip.pojo.entity.User;
import cn.ekgc.itrip.pojo.entity.UserLinkUser;
import cn.ekgc.itrip.transport.UserLinkUserTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;


@RestController("userLinkUserController")
@RequestMapping("/biz/api/userinfo")
public class UserLinkUserController extends BaseController {
    @Autowired
	private UserLinkUserTransport userLinkUserTransport;
	/**
	 * <b>根据当前登录用户，获得联系人</b>
	 */
	@PostMapping(value = "/queryuserlinkuser")
	public ResponseDto<Object> queryUserLinkUser()throws Exception{
		//通过 Cookie 获得当前用户
		String userCode = "";
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies){
			//user就等于是name的key
			if ("user".equals(cookie.getName())){
				userCode = cookie.getValue();
		}
		}
		//封装查询对象
		UserLinkUser query = new UserLinkUser();
		query.setUserCode(userCode);
		return ResponseDto.success(userLinkUserTransport.queryUserLinkUserListByQuery(query));
	}
}
