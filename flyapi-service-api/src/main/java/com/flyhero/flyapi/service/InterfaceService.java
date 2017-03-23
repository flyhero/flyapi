package com.flyhero.flyapi.service;

import java.io.File;
import java.io.IOException;

import com.flyhero.flyapi.entity.Interfaces;
import com.flyhero.flyapi.entity.User;
import com.flyhero.flyapi.pojo.InterPojo;
import com.github.pagehelper.PageInfo;

public interface InterfaceService {

	PageInfo<InterPojo> findInterByWhere(InterPojo interPojo);

	File findAllInter(Integer projectId) throws IOException;

	Interfaces selectByPrimaryKey(Integer interfaceId);

	int insertSelective(Interfaces record);
	
	void addInterface(Interfaces interfaces, Integer projectId,User user);

}
