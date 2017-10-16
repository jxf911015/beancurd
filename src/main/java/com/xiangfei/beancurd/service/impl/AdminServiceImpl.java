package com.xiangfei.beancurd.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiangfei.beancurd.common.Const;
import com.xiangfei.beancurd.common.ServerResponse;
import com.xiangfei.beancurd.dao.AdminMapper;
import com.xiangfei.beancurd.pojo.Admin;
import com.xiangfei.beancurd.service.IAdminService;
import com.xiangfei.beancurd.util.MD5Util;

@Service("iAdminService")
public class AdminServiceImpl implements IAdminService {

	@Autowired
	private AdminMapper adminMapper; 
	
	/**
	 * <p>Title: register</p>
	 * <p>Description: 注册接口</p>
	 * @param admin
	 * @param request
	 * @return
	 */
	@Override
	public ServerResponse register(Admin admin, HttpServletRequest request) {
		// TODO Auto-generated method stub
		//校验用户名
		ServerResponse<String> validname = this.checkValid(admin.getAdmname(),Const.ADMINNAME);
		if(!validname.isSuccess()){ 
			return validname;
		}
		//校验手机号
		ServerResponse<String> validphone = this.checkValid(admin.getPhone(),Const.PHONE);
		if(!validphone.isSuccess()){ 
			return validphone;
		}
		//MD5加密
		System.out.println("用户注册-输入的密码："+admin.getPassword());
		admin.setPassword(MD5Util.MD5EncodeUtf8(admin.getPassword()));
		int resultCount = adminMapper.insert(admin);
		//判断是否注册成功
		if(resultCount > 0){
			//注册成功，赋予权限制
			String admname = admin.getAdmname();
			Admin selcetadm= adminMapper.selectadmin(admname);
			Integer adminId = selcetadm.getId();
			selcetadm.setRole(1);
			int c = adminMapper.updateByPrimaryKey(selcetadm);
			//判断权限设置
			if(c > 0){
				System.out.println("用户权限值更新成功");
			}
			return ServerResponse.createBySuccess("adminId", adminId);
		}
		return ServerResponse.createByErrorMessage("注册失败");
	}   

	/**
	 * <p>Title: checkValid</p>
	 * <p>Description: 验证商户信息接口</p>
	 * @param str
	 * @param type
	 * @return
	 */
	public ServerResponse<String> checkValid(String str,String type){
		//判断用户名、手机类型
        if(StringUtils.isNotBlank(type)){
            //开始校验
        	if(Const.ADMINNAME.equals(type)){
                int resultCount = adminMapper.checkadmname(str);
                if(resultCount > 0 ){
                    return ServerResponse.createByErrorMessage("用户名已经存在");
                }
            }
            if(Const.PHONE.equals(type)){
                int resultCount = adminMapper.checkPhone(str);
                if(resultCount > 0 ){
                    return ServerResponse.createByErrorMessage("手机号已存在");
                }
            }
        }else {
            return ServerResponse.createByErrorMessage("参数错误");
        }
        return ServerResponse.createBySuccessMessage("校验成功");
    }
	
	/**
	 * <p>Title: checkValid</p>
	 * <p>Description: 登录接口</p>
	 * @param str
	 * @param type
	 * @return
	 */
	public ServerResponse login(String phone,String password,HttpServletRequest request ){
		Admin admin = adminMapper.selectadmmessage(phone);
		System.out.println(admin.toString());
		if(admin == null ){
			System.out.println("该商户信息不存在");
			return ServerResponse.createByErrorMessage("该商户信息不存在");
		}
		String md5Password = MD5Util.MD5EncodeUtf8(password);
		Admin adm = adminMapper.selectLogin(phone, md5Password);
		if(adm == null){
			return ServerResponse.createByErrorMessage("密码错误");
		}
		//设置缓存
		request.getSession().setAttribute("adm", adm);
		System.out.println("存入session中信息："+request.getSession().getAttribute("adm"));
		return ServerResponse.createBySuccess("登录成功", admin);
	}
	
}
