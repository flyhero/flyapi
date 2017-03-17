package com.flyhero.flyapi.service;

import java.util.List;
import java.util.Map;
import com.flyhero.flyapi.entity.OperateLog;
import com.github.pagehelper.PageInfo;

public interface LogService {

	int addLog(OperateLog log);

	/**
	 * 
	 * @Title: findLog
	 * @param @param projectId
	 * @param @return
	 * @return Map<String,Object>
	 * @throws
	 */
	Map<String, Object> findLog(Integer projectId);

	/**
	 * 根据项目号获取日志详细信息
	 * 
	 * @Title: findLogDetialByProId
	 * @author flyhero(http://flyhero.top)
	 * @date 2016年11月23日 上午11:00:55
	 * @param @param projectId
	 * @param @return
	 * @return List<OperateLog> 返回类型
	 * @throws
	 */
	List<OperateLog> findLogDetialByProId(Integer projectId);

	PageInfo<OperateLog> findAllLogByUserId(Integer userId, Integer pageNumber,
			Integer pageSize);
}
