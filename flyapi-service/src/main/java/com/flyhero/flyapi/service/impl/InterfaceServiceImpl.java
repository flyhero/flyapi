package com.flyhero.flyapi.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.flyhero.flyapi.dao.InterfacesMapper;
import com.flyhero.flyapi.entity.Interfaces;
import com.flyhero.flyapi.entity.OperateLog;
import com.flyhero.flyapi.entity.User;
import com.flyhero.flyapi.entity.UserProject;
import com.flyhero.flyapi.pojo.InterPojo;
import com.flyhero.flyapi.pojo.InterfacesPojo;
import com.flyhero.flyapi.pojo.JSONResult;
import com.flyhero.flyapi.pojo.Message;
import com.flyhero.flyapi.pojo.ParamPojo;
import com.flyhero.flyapi.pojo.TeamMemberPojo;
import com.flyhero.flyapi.service.InterfaceService;
import com.flyhero.flyapi.service.LogService;
import com.flyhero.flyapi.service.ProjectService;
import com.flyhero.flyapi.service.UserProjectService;
import com.flyhero.flyapi.utils.Constant;
import com.flyhero.flyapi.utils.DocUtil;
import com.flyhero.flyapi.utils.FormatUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class InterfaceServiceImpl implements InterfaceService{

	@Autowired
	private InterfacesMapper interfacesMapper;
	@Autowired
	private LogService LogService;
	@Autowired
	private ProjectService projectService;
	@Autowired
	private UserProjectService userProjectService;

	public PageInfo<InterPojo> findInterByWhere(InterPojo interPojo) {
		PageHelper
				.startPage(interPojo.getPageNumber(), interPojo.getPageSize());
		List<InterPojo> list = interfacesMapper.findInterByWhere(interPojo);
		PageInfo<InterPojo> pageInfo = new PageInfo<InterPojo>(list);
		return pageInfo;
	}

	public File findAllInter(Integer projectId) throws IOException {
		List<Interfaces> list = interfacesMapper.findAllInter(projectId);
		List<ParamPojo> pList = new ArrayList<ParamPojo>();
		List<InterfacesPojo> pInterfacesPojos = new ArrayList<InterfacesPojo>();
		for (Interfaces inter : list) {
			InterfacesPojo pInterfacesPojo = new InterfacesPojo();
			pInterfacesPojo.setInterName(inter.getInterName());
			pInterfacesPojo.setInterDes(inter.getInterDes());
			pInterfacesPojo.setInterUrl(inter.getInterUrl());
			pInterfacesPojo.setStatus(inter.getStatus()==0 ? "可用":"不可用");
			pInterfacesPojo.setMethod(inter.getMethod());
			pInterfacesPojo.setRequestExam(FormatUtil.formatJsonString(inter.getRequestExam().replace(" ", "")));
			pInterfacesPojo.setResponseParam(FormatUtil.formatJsonString(inter.getResponseParam().replace(" ", "")));
			pInterfacesPojo.setTrueExam(FormatUtil.formatJsonString(inter.getTrueExam().replace(" ", "")));
			pInterfacesPojo.setFalseExam(FormatUtil.formatJsonString(inter.getFalseExam().replace(" ", "")));
			pList = JSONObject.parseArray(inter.getParam(), ParamPojo.class);
			pInterfacesPojo.setParam(pList);
			pInterfacesPojos.add(pInterfacesPojo);
		}

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("interList", pInterfacesPojos);
		return DocUtil.createWord(map);
	}

	public Interfaces selectByPrimaryKey(Integer interfaceId) {
		return interfacesMapper.selectByPrimaryKey(interfaceId);
	}

	public int insertSelective(Interfaces record) {
		record.setRequestExam(record.getRequestExam().replace(" ", ""));
		record.setResponseParam(record.getResponseParam().replace(" ", ""));
		record.setTrueExam(record.getTrueExam().replace(" ", ""));
		record.setFalseExam(record.getFalseExam().replace(" ", ""));
		return interfacesMapper.insertSelective(record);
	}

	@Override
	public void addInterface(Interfaces interfaces, Integer projectId, User user) {
		int flag = interfacesMapper.insertSelective(interfaces);
		if (flag != 0) {
			interfaces.setContent("");
			OperateLog log = new OperateLog(user.getUserId(),
						user.getUserName(), projectId,
						Constant.TYPE_INSERT, Constant.CLASS_INTERFACE,
						Constant.NAME_INTERFACE, "新建：【"
								+ interfaces.getInterName() + "】接口",
						JSONObject.toJSONString(interfaces));
			LogService.addLog(log);
			projectService.updateDoneCount(projectId);
		}	
	}


}
