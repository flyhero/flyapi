package com.flyhero.flyapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flyhero.flyapi.dao.ResumeMapper;
import com.flyhero.flyapi.entity.Resume;

@Service
public class ResumeServiceImpl {

	@Autowired
	private ResumeMapper resumeMapper;

	public int saveUserResume(Resume resume) {
		int flag = 0;
		try {
			flag = resumeMapper.insertSelective(resume);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public Resume findOneResume(Integer resumeId) {
		Resume resume = null;
		try {
			resume = resumeMapper.selectByPrimaryKey(resumeId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resume;
	}
	
	public Resume findResumeByUserId(Integer userId) {
		Resume resume = null;
		try {
			resume = resumeMapper.findResumeByUserId(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resume;
	}
}
