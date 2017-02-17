package com.flyhero.flyapi.dao;

import java.util.List;

import com.flyhero.flyapi.entity.Interfaces;
import com.flyhero.flyapi.pojo.InterPojo;

public interface InterfacesMapper {
	
	List<InterPojo> findInterByWhere(InterPojo interPojo);
	
	List<Interfaces> findAllInter(Integer projectId);
	
    int deleteByPrimaryKey(Integer interfaceId);

    int insert(Interfaces record);

    int insertSelective(Interfaces record);

    Interfaces selectByPrimaryKey(Integer interfaceId);

    int updateByPrimaryKeySelective(Interfaces record);

    int updateByPrimaryKeyWithBLOBs(Interfaces record);

    int updateByPrimaryKey(Interfaces record);
}