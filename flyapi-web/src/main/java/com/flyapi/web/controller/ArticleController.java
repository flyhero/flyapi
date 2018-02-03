package com.flyapi.web.controller;

import com.flyapi.core.base.BaseController;
import com.flyapi.core.constant.JSONResult;
import com.flyapi.model.CmsArticle;
import com.flyapi.model.CmsComment;
import com.flyapi.model.CmsSubject;
import com.flyapi.model.UcenterUser;
import com.flyapi.service.api.*;
import com.flyapi.pojo.vo.ArticleDetailVo;
import com.flyapi.pojo.vo.ArticleSimpleVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * author: flyhero
 * Date: 2017/6/19 0019 下午 2:17
 */
@Controller
@RequestMapping("article")
public class ArticleController extends BaseController {

    private Logger logger = LogManager.getLogger(ArticleController.class);

    @Autowired
    private ArticleService articleService;
    @Autowired
    private UserService userService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private UserFameService userFameService;
    @Autowired
    private SubjectService subjectService;
    /**
     * Title: findArticleDetail
     * params: [articleId]
     * return: org.springframework.web.servlet.ModelAndView
     * author: flyhero(http://www.iflyapi.cn)
     * date: 2017/6/22 0022 上午 11:35
     */
    @RequestMapping(value = "detail/{articleId}",method = RequestMethod.GET)
    public ModelAndView findArticleDetail(@PathVariable("articleId")Long articleId){

        if(isLogin()){
            UcenterUser user = (UcenterUser)currentUser();
            userFameService.addFameValue(user.getUserId(),4);
        }
        ArticleDetailVo detailVo = articleService.findArticleDetail(articleId);
        List<CmsComment> commentList =commentService.findCommentById(articleId);
        mv.addObject("detailVo",detailVo);
        mv.addObject("commentList",commentList);
        mv.setViewName("article/detail");
        return mv;
    }
    /**
     * 根据专题获取文章列表
     * Title: findArticleBySubjectId
     * params: [subjectId]
     * return: org.springframework.web.servlet.ModelAndView
     * author: flyhero(http://www.iflyapi.cn)
     * date: 2017/6/22 0022 上午 11:35
     */
    @GetMapping("list/{subjectId}/{title}")
    public ModelAndView findArticleBySubjectId(@PathVariable Long subjectId,@PathVariable String title){
        List<CmsArticle> list = articleService.findArticleBySubjectId(subjectId);

        mv.addObject("articleList",list);
        mv.addObject("title",title);
        mv.setViewName("article/sub-timeline");
        return mv;
    }

    /**
     * Title: findArticleList
     * params: [pageNum, pageSize]
     * return: com.flyapi.core.constant.JSONResult
     * author: flyhero(http://www.iflyapi.cn)
     * date: 2017/6/22 0022 上午 11:10
     */
    @ResponseBody
    @RequestMapping("findArticleList")
    public JSONResult findArticleList(int pageNum,int pageSize){
        PageInfo<ArticleSimpleVo> pageInfo = null;
        PageHelper.startPage(pageNum, pageSize);
        try{
            List<ArticleSimpleVo> list = articleService.findArticleSimple();
            pageInfo = new PageInfo<ArticleSimpleVo>(list);
        }catch (Exception ex){
            return JSONResult.error();
        }

        return JSONResult.ok(pageInfo);
    }

    /**
     * Title: findLastUpdateOrHotArticles
     * params: [type]
     * return: com.flyapi.core.constant.JSONResult
     * author: flyhero(http://www.iflyapi.cn)
     * date: 2017/6/22 0022 下午 6:11
     */
    @ResponseBody
    @RequestMapping("findLastUpdateOrHotArticles")
    public JSONResult findLastUpdateOrHotArticles(int type){
        logger.info("接收值："+type);
        List<CmsArticle> list =null;
        try{
            list=articleService.findLastUpdateOrHotArticles(type);
        }catch (Exception e){
            logger.error(e.toString());
            return JSONResult.error();
        }
        return JSONResult.ok(list);
    }

    /**
     * Title: findArticleListByUserId
     * params: long userId,int pageNum,int pageSize
     * return: com.flyapi.core.constant.JSONResult
     * author: flyhero(http://www.iflyapi.cn)
     * date: 2017/9/23 0022 下午 1:53
     */
    @ResponseBody
    @RequestMapping("findArticleListByUserId/{userId}")
    public JSONResult findArticleListByUserId(@PathVariable long userId,int pageNum,int pageSize){
        PageInfo<CmsArticle> pageInfo = null;
        PageHelper.startPage(pageNum, pageSize);
        try{
            List<CmsArticle> list = articleService.findArticleByUserId(userId);
            if(list == null || list.isEmpty()){
                return JSONResult.error();
            }
            pageInfo = new PageInfo<CmsArticle>(list);
        }catch (Exception ex){
            return JSONResult.error();
        }
        return JSONResult.ok(pageInfo);
    }

    /**
     * 前往添加编辑页
     * @title: gotoAddPage
     * @author qfwang
     * @param articleId
     * @return org.springframework.web.servlet.ModelAndView
     * @date 2018/2/3 下午2:35
     */
    @GetMapping("{articleId}")
    public ModelAndView gotoAddPage(@PathVariable Long articleId){


        mv.setViewName("article/add");

        UcenterUser user = (UcenterUser) currentUser();
        List<CmsSubject> subjectList = subjectService.findUserSubject(user.getUserId());
        if(subjectList == null || subjectList.size() == 0){
            mv.addObject("tip","请先创建主题,再写文章哦");
            return mv;
        }

        mv.addObject("subjectList",subjectList);

        CmsArticle article = articleService.selectByPrimaryKey(articleId);
        mv.addObject("article",article);


        return mv;

    }

    @ResponseBody
    @PostMapping("add")
    public JSONResult addArticle(){

        return JSONResult.ok();
    }

}
