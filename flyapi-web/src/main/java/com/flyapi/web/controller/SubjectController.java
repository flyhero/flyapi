package com.flyapi.web.controller;

import com.alibaba.druid.filter.AutoLoad;
import com.flyapi.core.base.BaseController;
import com.flyapi.core.constant.JSONResult;
import com.flyapi.pojo.dto.SubjectDto;
import com.flyapi.pojo.vo.SubjectVo;
import com.flyapi.service.api.SubjectService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by qfwang on 2017/6/24.
 */
@Controller
@RequestMapping("subject")
public class SubjectController extends BaseController{

    private Logger logger = LogManager.getLogger(SubjectController.class);
    @Autowired
    private SubjectService subjectService;
    /**
     * Title: findSubjectList
     * params: [subjectDto]
     * return: com.flyapi.core.constant.JSONResult
     * author: flyhero(http://flyhero.top)
     * date: 2017/6/27 0027 下午 2:29
     */
    @ResponseBody
    @RequestMapping("findSubjectList")
    public JSONResult findSubjectList(SubjectDto subjectDto){
        PageInfo<SubjectVo> pageInfo =null;
        PageHelper.startPage(subjectDto.getPageNum(),subjectDto.getPageSize());
        try {
            List<SubjectVo> list=subjectService.findSubjectList(subjectDto);
            pageInfo=new PageInfo<SubjectVo>(list);
        }catch (Exception e){
            logger.error(e.toString());
            return JSONResult.error();
        }

        return JSONResult.ok(pageInfo);
    }
}
