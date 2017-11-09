package com.flyapi.dao;

import com.flyapi.model.CmsComment;

import java.util.List;

public interface CmsCommentMapper {
    int deleteByPrimaryKey(Long commentId);

    int insert(CmsComment record);

    int insertSelective(CmsComment record);

    CmsComment selectByPrimaryKey(Long commentId);

    int updateByPrimaryKeySelective(CmsComment record);

    int updateByPrimaryKeyWithBLOBs(CmsComment record);

    int updateByPrimaryKey(CmsComment record);

    List<CmsComment> findCommentById(long targetId);
}