package com.flyhero.flyapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flyhero.flyapi.dao.VersionMapper;
import com.flyhero.flyapi.entity.Version;
import com.flyhero.flyapi.service.VersionService;

@Service
public class VersionServiceImpl implements VersionService{
	@Autowired
	private VersionMapper versionMapper;

	public List<Version> findVersionLog(){
		return versionMapper.findVersionLog();
	}
	
}
