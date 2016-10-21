package com.flyhero.flyapi.dao;

import java.util.List;

import com.flyhero.flyapi.entity.UserProject;

public interface UserProjectMapper {
    int deleteByPrimaryKey(Integer r1Id);

    int insert(UserProject record);

    int insertSelective(UserProject record);

    UserProject selectByPrimaryKey(Integer r1Id);
    
    UserProject selectByIdAndPro(UserProject up);

    int updateByPrimaryKeySelective(UserProject record);

    int updateByPrimaryKey(UserProject record);
    
    List selectMyProject(Integer userId);
}