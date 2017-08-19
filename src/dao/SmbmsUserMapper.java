package dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import entity.SmbmsUser;

public interface SmbmsUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SmbmsUser record);

    int insertSelective(SmbmsUser record);

    SmbmsUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SmbmsUser record);

    int updateByPrimaryKey(SmbmsUser record);
    
    @Select("select * from smbms_user where usercode = #{usercode}")
    SmbmsUser selectByPrimaryUserCode(String usercode);
    
    @Select("select * from smbms_user")
    List<SmbmsUser> selectUserByAll();
}