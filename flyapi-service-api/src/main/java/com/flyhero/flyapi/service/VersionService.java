package com.flyhero.flyapi.service;

import java.util.List;

import com.flyhero.flyapi.entity.Version;

public interface VersionService {

	List<Version> findVersionLog();

}
