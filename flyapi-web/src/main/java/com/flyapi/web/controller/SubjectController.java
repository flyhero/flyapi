package com.flyapi.web.controller;

import com.alibaba.druid.filter.AutoLoad;
import com.flyapi.core.base.BaseController;
import com.flyapi.core.constant.JSONResult;
import com.flyapi.service.api.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by qfwang on 2017/6/24.
 */
@Controller
@RequestMapping("subject")
public class SubjectController extends BaseController{
    @Autowired
    private SubjectService subjectService;

    @ResponseBody
    @RequestMapping("findSubjectList")
    public JSONResult findSubjectList(){
        return JSONResult.ok();
    }
}
