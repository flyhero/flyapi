package com.flyhero.flyapi.dao;

import java.util.List;

import com.flyhero.flyapi.entity.DataBase;

public interface DataBaseMapper {
    int deleteByPrimaryKey(Integer dbId);

    int insert(DataBase record);

    int insertSelective(DataBase record);

    DataBase selectByPrimaryKey(Integer dbId);
    
    List<DataBase> findDataBase(Integer userId);
    
    List<DataBase> findAllDB();

    int updateByPrimaryKeySelective(DataBase record);

    int updateByPrimaryKey(DataBase record);
}