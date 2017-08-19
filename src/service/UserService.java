package service;

import util.ResultData;
import entity.SmbmsUser;

public interface UserService {
	//����id��ѯ�û�
	public ResultData getUserById(Long id);
	
	//��֤��¼
	public ResultData isLogin(String usercode,String userpassword);
	
	//��ѯ����user��Ϣ
	public ResultData getUserByAll();
	
	//����û�
	public ResultData addUser(SmbmsUser user);
	
	//ɾ���û�
	public ResultData delUser(Long id);
}
