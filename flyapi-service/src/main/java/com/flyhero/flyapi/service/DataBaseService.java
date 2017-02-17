package com.flyhero.flyapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flyhero.flyapi.dao.DataBaseMapper;
import com.flyhero.flyapi.entity.DataBase;
import com.flyhero.flyapi.utils.DESUtil;

@Service
public class DataBaseService {

	@Autowired
	private DataBaseMapper dataBaseMapper;

	public int addDataBase(DataBase dataBase) {
		try {
			dataBase.setDbPassword(DESUtil.decrypt(dataBase.getDbPassword(),
					DESUtil.key));
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return dataBaseMapper.insertSelective(dataBase);
	}

	public List<DataBase> findDataBase(Integer userId) {
		return dataBaseMapper.findDataBase(userId);
	}

	public List<DataBase> findAllDB() {
		List<DataBase> list = dataBaseMapper.findAllDB();

		try {
			for (DataBase db : list) {
				db.setDbPassword(DESUtil.decrypt(db.getDbPassword(),
						DESUtil.key));
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return dataBaseMapper.findAllDB();
	}
}
