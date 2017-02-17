package com.flyhero.flyapi.dao;

import java.util.List;

import com.flyhero.flyapi.entity.WebInfo;

public interface WebInfoMapper {
    int deleteByPrimaryKey(Integer webId);

    int insert(WebInfo record);

    int insertSelective(WebInfo record);

    WebInfo selectByPrimaryKey(Integer webId);
    
    List<WebInfo> findAllByLanguage(String language);

    int updateByPrimaryKeySelective(WebInfo record);

    int updateByPrimaryKeyWithBLOBs(WebInfo record);

    int updateByPrimaryKey(WebInfo record);
}