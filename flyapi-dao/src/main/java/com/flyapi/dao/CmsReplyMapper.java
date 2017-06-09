package com.flyapi.dao;

import com.flyapi.model.CmsReply;

public interface CmsReplyMapper {
    int deleteByPrimaryKey(Long replyId);

    int insert(CmsReply record);

    int insertSelective(CmsReply record);

    CmsReply selectByPrimaryKey(Long replyId);

    int updateByPrimaryKeySelective(CmsReply record);

    int updateByPrimaryKey(CmsReply record);
}