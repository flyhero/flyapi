package com.flyhero.flyapi.service;

import java.util.List;

import com.flyhero.flyapi.entity.DataBase;

public interface DataBaseService {

	int addDataBase(DataBase dataBase);

	List<DataBase> findDataBase(Integer userId);

	List<DataBase> findAllDB();
}
