package com.flyhero.flyapi.service;

import com.flyhero.flyapi.entity.Resume;

public interface ResumeService {

	int saveUserResume(Resume resume);

	Resume findOneResume(Integer resumeId);

	Resume findResumeByUserId(Integer userId);
}
