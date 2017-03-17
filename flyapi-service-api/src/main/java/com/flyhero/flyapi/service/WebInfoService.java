package com.flyhero.flyapi.service;

import java.util.List;

import com.flyhero.flyapi.entity.WebInfo;

public interface WebInfoService{

	List<WebInfo> findAllByLanguage(String language);
	
}
