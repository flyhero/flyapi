package com.flyhero.flyapi.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flyhero.flyapi.dao.OperateLogMapper;
import com.flyhero.flyapi.entity.OperateLog;
import com.flyhero.flyapi.pojo.LogPojo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class LogService {
	
	@Autowired
	private OperateLogMapper operateLogMapper; 
	
	public int addLog(OperateLog log){
		return operateLogMapper.addLog(log);
	}
	/**
	 * 
	 * @Title: findLog 
	 * @param @param projectId
	 * @param @return   
	 * @return Map<String,Object>    
	 * @throws
	 */
	public Map<String, Object> findLog(Integer projectId){
		List<LogPojo> list=operateLogMapper.findLog(projectId);
		List<Integer> cList =new ArrayList<Integer>();
		List<String> xList =new ArrayList<String>();
		Map<String, Object> map=new HashMap<String, Object>();
		for(LogPojo log:list){
			cList.add(log.getCount());
			xList.add(log.getXtime());
		}
		map.put("count", cList);
		map.put("xtime", xList);
		return map;
	}
	
	/**
	 * 根据项目号获取日志详细信息
	 * @Title: findLogDetialByProId  
	 * @author flyhero(http://flyhero.top)
	 * @date 2016年11月23日 上午11:00:55 
	 * @param @param projectId
	 * @param @return    
	 * @return List<OperateLog>    返回类型 
	 * @throws
	 */
	public List<OperateLog> findLogDetialByProId(Integer projectId){
		return operateLogMapper.findLogDetialByProId(projectId);
	}
	public PageInfo<OperateLog> findAllLogByUserId(Integer userId,Integer pageNumber,Integer pageSize){
		PageHelper.startPage(pageNumber, pageSize);
		List<OperateLog> list=operateLogMapper.findAllLogByUserId(userId);
		PageInfo<OperateLog> pInfo=new PageInfo<OperateLog>(list);
		return pInfo;
	}
}
