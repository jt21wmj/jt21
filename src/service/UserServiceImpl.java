package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import util.ResultData;

import dao.SmbmsUserMapper;
import entity.SmbmsUser;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	@Autowired
	private SmbmsUserMapper smbmsUserMapper;
	@Override
	@Transactional(isolation=Isolation.DEFAULT,readOnly=true,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public ResultData getUserById(Long id) {
		ResultData rd = new ResultData();
		rd.setData(smbmsUserMapper.selectByPrimaryKey(id));
		return rd;
	}
	
	@Override
	public ResultData isLogin(String usercode, String userpassword) {
		SmbmsUser user = smbmsUserMapper.selectByPrimaryUserCode(usercode);
		ResultData rd = new ResultData();
		if(user != null){
			if(user.getUserpassword().equals(userpassword)){
				rd.setData(user);
				rd.setFlag(0);
				rd.setMsg("��¼�ɹ�!");
				return rd;
			}else{
				rd.setFlag(1);
				rd.setMsg("�������!");
				return rd;
			}
		}
		rd.setFlag(2);
		rd.setMsg("�û���������!");
		return rd;
	}

	@Override
	public ResultData getUserByAll() {
		ResultData rd = new ResultData();
		List<SmbmsUser> users = smbmsUserMapper.selectUserByAll();
		rd.setData(users);
		return rd;
	}

	@Override
	public ResultData addUser(SmbmsUser user) {
		ResultData rd = new ResultData();
		int len = smbmsUserMapper.insertSelective(user);
		if(len >0){
			rd.setFlag(0);
		}else{
			rd.setFlag(1);
			rd.setMsg("���ʧ��!");
		}
		return rd;
	}

	@Override
	public ResultData delUser(Long id) {
		ResultData rd = new ResultData();
		int len = smbmsUserMapper.deleteByPrimaryKey(id);
		if(len > 0){
			rd.setFlag(0);
			rd.setMsg("ɾ���ɹ�!");
		}else{
			rd.setFlag(1);
			rd.setMsg("ɾ��ʧ��!");
		}
		return rd;
	}
}
