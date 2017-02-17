package com.flyhero.flyapi.dao;

import java.util.List;

import com.flyhero.flyapi.entity.OperateLog;
import com.flyhero.flyapi.pojo.LogVo;

public interface OperateLogMapper {
	
	List<LogVo> findLog(Integer projectId);  
	
	List<OperateLog> findLogDetialByProId(Integer projectId);
	
	List<OperateLog> findAllLogByUserId(Integer userId);
	
    int deleteByPrimaryKey(Integer logId);

    int insert(OperateLog record);

    int addLog(OperateLog record);

    OperateLog selectByPrimaryKey(Integer logId);

    int updateByPrimaryKeySelective(OperateLog record);

    int updateByPrimaryKey(OperateLog record);
}