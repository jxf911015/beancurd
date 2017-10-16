package com.xiangfei.beancurd.service;

import javax.servlet.http.HttpServletRequest;

import com.xiangfei.beancurd.common.ServerResponse;
import com.xiangfei.beancurd.pojo.Admin;

public interface IAdminService {

	//注册接口
	ServerResponse register(Admin admin,HttpServletRequest request);
	//校验用户名与手机号接口
	ServerResponse<String> checkValid(String str,String type);
	//登录接口
	ServerResponse login(String phone,String password,HttpServletRequest request );
}
