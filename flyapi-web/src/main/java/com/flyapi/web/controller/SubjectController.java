package com.flyapi.web.controller;

import com.alibaba.druid.filter.AutoLoad;
import com.flyapi.core.base.BaseController;
import com.flyapi.core.constant.JSONResult;
import com.flyapi.model.CmsSubject;
import com.flyapi.model.UcenterUser;
import com.flyapi.pojo.dto.SubjectDto;
import com.flyapi.pojo.vo.SubjectVo;
import com.flyapi.service.api.SubjectService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.security.auth.Subject;
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
     * 前往主题编辑页
     * @title: editSubject
     * @author flyhero <http://www.iflyapi.cn>
     * @param subjectId
     * @return org.springframework.web.servlet.ModelAndView
     * @date 2018/1/30 下午11:13
     */
    @GetMapping("{subjectId}")
    public ModelAndView editSubject(@PathVariable Long subjectId){
        CmsSubject subject = subjectService.selectByPrimaryKey(subjectId);
        mv.addObject("subject",subject);
        mv.setViewName("article/add-subject");
        return mv;
    }


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
            UcenterUser user = (UcenterUser)currentUser();
            Long userId = null;
            if(user != null ){
                userId = user.getUserId();
            }
            List<SubjectVo> list=subjectService.findSubjectList(subjectDto,userId);
            pageInfo=new PageInfo<SubjectVo>(list);
        }catch (Exception e){
            logger.error(e.toString());
            return JSONResult.error();
        }

        return JSONResult.ok(pageInfo);
    }
    /**
     * Title: findSubjectByUserId
     * params: Long userId,int pageNum,int pageSize
     * return: com.flyapi.core.constant.JSONResult
     * author: flyhero(http://flyhero.top)
     * date: 2017/9/23 0027 下午 1:42
     */
    @ResponseBody
    @GetMapping("findSubjectByUserId/{userId}")
    public JSONResult findSubjectByUserId(@PathVariable Long userId,int pageNum,int pageSize){
        PageInfo<CmsSubject> pageInfo =null;
        PageHelper.startPage(pageNum,pageSize);
        try {
            List<CmsSubject> list =subjectService.findUserSubject(userId);
            if (list == null || list.isEmpty()){
                return JSONResult.error();
            }
            pageInfo=new PageInfo<CmsSubject>(list);
        }catch (Exception e){
            logger.error(e.toString());
            return JSONResult.error();
        }
        return JSONResult.ok(pageInfo);
    }

    /**
     * 根据专题id前往修改专题页面
     * Title: goUpdateSubject
     * params: Long subjectId
     * return: ModelAndView
     * author: flyhero(http://flyhero.top)
     * date: 2017/9/23 0027 下午 2:57
     */
    @ResponseBody
    @GetMapping("goUpdateSubject/{subjectId}")
    public ModelAndView goUpdateSubject(@PathVariable Long subjectId){
        CmsSubject cmsSubject =null;
        try {
            cmsSubject =subjectService.selectByPrimaryKey(subjectId);
        }catch (Exception e){
            logger.error(e.toString());
        }
        mv.addObject("cmsSubject",cmsSubject);
        mv.setViewName("html/user/update-sub");
        return mv;
    }
}
