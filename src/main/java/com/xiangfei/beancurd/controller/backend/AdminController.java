package com.xiangfei.beancurd.controller.backend;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiangfei.beancurd.common.ServerResponse;
import com.xiangfei.beancurd.dao.AdminMapper;
import com.xiangfei.beancurd.pojo.Admin;
import com.xiangfei.beancurd.service.IAdminService;

@CrossOrigin
@Controller
@RequestMapping("/admin/")
public class AdminController {

	@Autowired
	private IAdminService iAdminService;
	
	@Autowired
	private AdminMapper adminMapper;
	
	
	/**  
	 * <p>Title: register</p>
	 * <p>Description:注册接口 </p>
	 * @param admin
	 * @return
	 */
	@RequestMapping(value = "register.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse register(Admin admin,HttpServletRequest request){
		if(admin == null){
			return ServerResponse.createByErrorMessage("请完善用户注册信息");
		}
		
		String admname = request.getParameter("admname");
		System.out.println(admname);
		String password = request.getParameter("password");
		System.out.println(password);
		String phone = request.getParameter("phone");
		System.out.println(phone);
		
		return iAdminService.register(admin,request);
    }
	
	/**  
	 * <p>Title: checkValid</p>
	 * <p>Description:校验注册信息接口 </p>
	 * @param str
	 * @param type
	 * @return
	 */
	@RequestMapping(value = "checkValid.do",method = RequestMethod.POST)
	@ResponseBody
	public ServerResponse checkValid(String str,String type){
		return iAdminService.checkValid(str, type);
	}
	
	/**
	 * <p>Title: login</p>
	 * <p>Description:登录接口 </p>
	 * @param phone
	 * @param password
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "login.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse login(String phone,String password,HttpServletRequest request){
		if(phone == null){
			System.out.println("您输入的用户名/手机号为空，请重新输入");
			return ServerResponse.createByErrorMessage("您输入的用户名/手机号为空，请重新输入");
		}
		return iAdminService.login(phone, password,request);
	}
	
}
