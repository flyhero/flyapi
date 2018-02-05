package com.flyapi.web.controller;

import com.alibaba.druid.filter.AutoLoad;
import com.flyapi.core.base.BaseController;
import com.flyapi.core.constant.JSONResult;
import com.flyapi.core.id.SnowflakeIdWorker;
import com.flyapi.model.CmsArticle;
import com.flyapi.model.CmsRss;
import com.flyapi.model.CmsSubject;
import com.flyapi.model.UcenterUser;
import com.flyapi.pojo.dto.SubjectDto;
import com.flyapi.pojo.vo.SubjectVo;
import com.flyapi.pojo.vo.UserSubjectVo;
import com.flyapi.service.api.ArticleService;
import com.flyapi.service.api.RssService;
import com.flyapi.service.api.SubjectService;
import com.flyapi.service.api.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.security.auth.Subject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by qfwang on 2017/6/24.
 */
@Controller
@RequestMapping("subject")
public class SubjectController extends BaseController {

    private Logger logger = LogManager.getLogger(SubjectController.class);
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private UserService userService;
    @Autowired
    private RssService rssService;
    @Autowired
    private SnowflakeIdWorker snowflakeIdWorker;

    /**
     * 前往主题编辑页
     *
     * @param subjectId
     * @return org.springframework.web.servlet.ModelAndView
     * @title: editSubject
     * @author flyhero <http://www.iflyapi.cn>
     * @date 2018/1/30 下午11:13
     */
    @GetMapping("{subjectId}")
    public ModelAndView editSubject(@PathVariable Long subjectId) {
        CmsSubject subject = subjectService.selectByPrimaryKey(subjectId);
        mv.addObject("subject", subject);
        mv.setViewName("article/add-subject");
        return mv;
    }

    /**
     * 订阅主题
     *
     * @param subjectId
     * @return com.flyapi.core.constant.JSONResult
     * @title: rssSubject
     * @author flyhero <http://www.iflyapi.cn>
     * @date 2018/2/5 下午11:18
     */
    @PostMapping("rss/{subjectId}")
    @ResponseBody
    public JSONResult rssSubject(@PathVariable Long subjectId) {
        UcenterUser user = (UcenterUser) currentUser();
        CmsRss rss = new CmsRss();
        rss.setRssId(snowflakeIdWorker.nextId());
        rss.setSubjectId(subjectId);
        rss.setUserId(user.getUserId());
        int num = rssService.insertSelective(rss);
        return JSONResult.ok();
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
    public JSONResult findSubjectList(SubjectDto subjectDto) {
        PageInfo<SubjectVo> pageInfo = null;
        PageHelper.startPage(subjectDto.getPageNum(), subjectDto.getPageSize());
        try {
            UcenterUser user = (UcenterUser) currentUser();
            Long userId = null;
            if (user != null) {
                userId = user.getUserId();
            }
            List<SubjectVo> list = subjectService.findSubjectList(subjectDto, userId);
            pageInfo = new PageInfo<SubjectVo>(list);
        } catch (Exception e) {
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
    @GetMapping("subjects/{userId}")
    public JSONResult findSubjectByUserId(@PathVariable Long userId, int pageNum, int pageSize) {
        PageInfo<CmsSubject> pageInfo = null;
        List<UserSubjectVo> subjectVoList = null;
        PageHelper.startPage(pageNum, pageSize);
        try {
            List<CmsSubject> list = subjectService.findUserSubject(userId);
            if (list == null || list.isEmpty()) {
                return JSONResult.error();
            }
            pageInfo = new PageInfo<CmsSubject>(list);
            List<CmsSubject> pageInfoList = pageInfo.getList();

            subjectVoList = new ArrayList<UserSubjectVo>();
            for (CmsSubject subject : pageInfoList) {
                UserSubjectVo userSubjectVo = new UserSubjectVo();
                BeanUtils.copyProperties(subject, userSubjectVo);

                CmsArticle article = articleService.findArticleSumBySubjectId(subject.getSubjectId());
                userSubjectVo.setCmsArticle(article);

                UcenterUser user = userService.selectByPrimaryKey(subject.getUserId());
                user.setPassword("");
                user.setPhone("");
                userSubjectVo.setUcenterUser(user);


                CmsRss cmsRss = new CmsRss();
                cmsRss.setSubjectId(subject.getSubjectId());
                List<CmsRss> cmsRssList = rssService.findByUserIdAndSubjectId(cmsRss);
                userSubjectVo.setRssNum(cmsRssList.size());

                UcenterUser current = (UcenterUser) currentUser();
                if (current == null || current.getUserId() == 0) {
                    userSubjectVo.setRss(false);
                } else {
                    cmsRss.setUserId(current.getUserId());
                    List<CmsRss> cmsRsses = rssService.findByUserIdAndSubjectId(cmsRss);
                    if (cmsRsses != null && cmsRsses.size() > 0) {
                        userSubjectVo.setRss(true);
                    }
                }
                subjectVoList.add(userSubjectVo);

            }
        } catch (Exception e) {
            logger.error(e.toString());
            return JSONResult.error();
        }
        return JSONResult.ok(subjectVoList);
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
    public ModelAndView goUpdateSubject(@PathVariable Long subjectId) {
        CmsSubject cmsSubject = null;
        try {
            cmsSubject = subjectService.selectByPrimaryKey(subjectId);
        } catch (Exception e) {
            logger.error(e.toString());
        }
        mv.addObject("cmsSubject", cmsSubject);
        mv.setViewName("html/user/update-sub");
        return mv;
    }
}
