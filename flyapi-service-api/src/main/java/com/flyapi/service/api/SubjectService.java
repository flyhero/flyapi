package com.flyapi.service.api;

import com.flyapi.core.base.BaseService;
import com.flyapi.model.CmsSubject;
import com.flyapi.pojo.dto.SubjectDto;
import com.flyapi.pojo.vo.SubjectVo;

import java.util.List;

/**
 * author: flyhero
 * Date: 2017/6/9 0009 下午 3:57
 */
public interface SubjectService extends BaseService<CmsSubject> {
    List<SubjectVo> findSubjectList(SubjectDto subjectDto);

    List<CmsSubject> findUserSubject(Long userId);

}
