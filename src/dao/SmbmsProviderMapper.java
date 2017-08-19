package dao;

import entity.SmbmsProvider;

public interface SmbmsProviderMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SmbmsProvider record);

    int insertSelective(SmbmsProvider record);

    SmbmsProvider selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SmbmsProvider record);

    int updateByPrimaryKey(SmbmsProvider record);
}