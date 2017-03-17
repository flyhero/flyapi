package com.flyhero.flyapi.service;

import java.util.List;
import com.flyhero.flyapi.entity.TableInfo;

/**
 * 
 * @ClassName: TableInfoService
 * @author flyhero(http://flyhero.top)
 * @date 2016年11月29日 下午1:40:20
 *
 */
public interface TableInfoService {

	int addTableInfo(TableInfo tableInfo);

	List<String> findTableNameByDbId(Integer dbId);

	List<TableInfo> findInfoByTableName(String tableName);

}
