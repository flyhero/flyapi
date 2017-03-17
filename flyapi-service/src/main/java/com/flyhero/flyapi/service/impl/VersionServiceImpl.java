package com.flyhero.flyapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flyhero.flyapi.dao.VersionMapper;
import com.flyhero.flyapi.entity.Version;

@Service
public class VersionServiceImpl{
	@Autowired
	private VersionMapper versionMapper;

	public List<Version> findVersionLog(){
		return versionMapper.findVersionLog();
	}
	
}
