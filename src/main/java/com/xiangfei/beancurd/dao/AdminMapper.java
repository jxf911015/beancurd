package com.xiangfei.beancurd.dao;

import org.apache.ibatis.annotations.Param;

import com.xiangfei.beancurd.pojo.Admin;

public interface AdminMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
    //校验用户名
    int checkadmname(@Param("admname") String admname);
    //检验手机号
    int checkPhone(@Param("phone") String phone);
    //查询用户注册信息
    Admin selectadmin(@Param("admname") String admname);
    //查询用户信息
    Admin selectadmmessage(@Param("phone") String phone);
    //用户登录
    Admin selectLogin(@Param("phone") String phone, @Param("password")String password);
}