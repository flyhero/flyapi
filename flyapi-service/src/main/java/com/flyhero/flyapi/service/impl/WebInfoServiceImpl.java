package com.flyhero.flyapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flyhero.flyapi.dao.WebInfoMapper;
import com.flyhero.flyapi.entity.WebInfo;

@Service
public class WebInfoServiceImpl{
	@Autowired
	private WebInfoMapper webInfoMapper;

	public List<WebInfo> findAllByLanguage(String language){
		return webInfoMapper.findAllByLanguage(language);
	}
	
}
