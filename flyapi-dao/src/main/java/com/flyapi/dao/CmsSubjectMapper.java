package com.flyapi.dao;

import com.flyapi.model.CmsSubject;

import java.util.List;

public interface CmsSubjectMapper {
    int deleteByPrimaryKey(Long subjectId);

    int insert(CmsSubject record);

    int insertSelective(CmsSubject record);

    CmsSubject selectByPrimaryKey(Long subjectId);

    int updateByPrimaryKeySelective(CmsSubject record);

    int updateByPrimaryKey(CmsSubject record);

    List<CmsSubject> findSubjectList();
}