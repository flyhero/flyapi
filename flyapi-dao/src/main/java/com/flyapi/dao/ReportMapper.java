package com.flyapi.dao;

import com.flyapi.model.Report;

public interface ReportMapper {
    int deleteByPrimaryKey(Long reportId);

    int insert(Report record);

    int insertSelective(Report record);

    Report selectByPrimaryKey(Long reportId);

    int updateByPrimaryKeySelective(Report record);

    int updateByPrimaryKey(Report record);

    int findCountByIP(String ip);
}