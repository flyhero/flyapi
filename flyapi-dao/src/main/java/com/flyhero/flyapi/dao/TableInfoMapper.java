package com.flyhero.flyapi.dao;

import java.util.List;

import com.flyhero.flyapi.entity.TableInfo;

public interface TableInfoMapper {
	
	List<String> findTableNameByDbId(Integer dbId);
	
	List<TableInfo> findInfoByTableName(String tableName);
	
    int deleteByPrimaryKey(Integer id);

    int insert(TableInfo record);

    int insertSelective(TableInfo record);

    TableInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TableInfo record);

    int updateByPrimaryKey(TableInfo record);
}