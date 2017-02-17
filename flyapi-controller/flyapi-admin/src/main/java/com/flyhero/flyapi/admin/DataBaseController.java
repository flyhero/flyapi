package com.flyhero.flyapi.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flyhero.flyapi.entity.DataBase;
import com.flyhero.flyapi.entity.TableInfo;
import com.flyhero.flyapi.pojo.JSONResult;
import com.flyhero.flyapi.service.DataBaseService;
import com.flyhero.flyapi.service.TableInfoService;
import com.flyhero.flyapi.utils.Constant;
/**
 * 数据字典控制器
 * @ClassName: DataBaseController 
 * @author flyhero(http://flyhero.top)
 * @date 2016年11月28日 上午10:13:55 
 *
 */
@Controller
@RequestMapping("db")
public class DataBaseController extends BaseController{
	
	@Autowired
	private DataBaseService dataBaseService;
	
	@Autowired
	private TableInfoService tableInfoService;
	
	/**
	 * 添加数据字典
	 * @Title: addDataBase 
	 * @author flyhero(http://flyhero.top)  
	 * @date 2016年11月28日 上午10:14:16 
	 * @param @param database
	 * @param @return   
	 * @return JSONResult    
	 * @throws
	 */
	@RequestMapping("addDataBase.do")
	public String addDataBase(DataBase database){
		int flag=dataBaseService.addDataBase(database);
		return "redirect:list_database";
	}
	/**
	 * 获取数据字典
	 * @Title: findDataBase 
	 * @author flyhero(http://flyhero.top)  
	 * @date 2016年11月28日 上午11:40:37 
	 * @param @param userId
	 * @param @return   
	 * @return JSONResult    
	 * @throws
	 */
	@ResponseBody
	@RequestMapping("findDataBase.do")
	public JSONResult findDataBase(Integer userId){
		List<DataBase> dataBase=dataBaseService.findDataBase(userId);
		if(dataBase != null && !dataBase.isEmpty()){
			return new JSONResult(Constant.MSG_OK, Constant.CODE_200, dataBase);
		}
		return new JSONResult(Constant.MSG_ERROR, Constant.CODE_200, dataBase);
		
	}
	/**
	 * 获取表信息
	 * @Title: findTableInfo 
	 * @author flyhero(http://flyhero.top)  
	 * @date 2016年11月29日 下午3:58:20 
	 * @param @param dbId
	 * @param @return   
	 * @return JSONResult    
	 * @throws
	 */
	@ResponseBody
	@RequestMapping("findTableInfo.do")
	public JSONResult findTableInfo(Integer dbId){
		List<String> tableNameList=tableInfoService.findTableNameByDbId(dbId);
		List<List<TableInfo>> list=new ArrayList<List<TableInfo>>();
		if(tableNameList != null && !tableNameList.isEmpty()){
			for(String tableName:tableNameList){
				List<TableInfo> infoslist=tableInfoService.findInfoByTableName(tableName);
				list.add(infoslist);
			}
			return new JSONResult(Constant.MSG_OK, Constant.CODE_200, list);
		}
		return new JSONResult(Constant.MSG_ERROR, Constant.CODE_200, list);
		
	}

}
