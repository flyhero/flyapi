package com.flyhero.flyapi.dao;

import com.flyhero.flyapi.entity.Comments;

public interface CommentsMapper {
    int deleteByPrimaryKey(Integer commentId);
    
    int insert(Comments record);

    int insertSelective(Comments record);

    Comments selectByPrimaryKey(Integer commentId);

    int updateByPrimaryKeySelective(Comments record);

    int updateByPrimaryKey(Comments record);
}