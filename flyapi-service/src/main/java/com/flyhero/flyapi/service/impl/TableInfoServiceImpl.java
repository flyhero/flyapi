package com.flyhero.flyapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flyhero.flyapi.dao.TableInfoMapper;
import com.flyhero.flyapi.entity.TableInfo;
import com.flyhero.flyapi.service.TableInfoService;

/**
 * 
 * @ClassName: TableInfoService 
 * @author flyhero(http://flyhero.top)
 * @date 2016年11月29日 下午1:40:20 
 *
 */
@Service
public class TableInfoServiceImpl implements TableInfoService{
	
	@Autowired
	private TableInfoMapper tableInfoMapper;
	
	public int addTableInfo(TableInfo tableInfo){
		return tableInfoMapper.insertSelective(tableInfo);
	}
	
	public List<String> findTableNameByDbId(Integer dbId){
		return tableInfoMapper.findTableNameByDbId(dbId);
	}
	
	public List<TableInfo> findInfoByTableName(String tableName){
		return tableInfoMapper.findInfoByTableName(tableName);
	}
	
}
