package service;

import util.ResultData;
import entity.SmbmsUser;

public interface UserService {
	//根据id查询用户
	public ResultData getUserById(Long id);
	
	//验证登录
	public ResultData isLogin(String usercode,String userpassword);
	
	//查询所有user信息
	public ResultData getUserByAll();
	
	//添加用户
	public ResultData addUser(SmbmsUser user);
	
	//删除用户
	public ResultData delUser(Long id);
}
