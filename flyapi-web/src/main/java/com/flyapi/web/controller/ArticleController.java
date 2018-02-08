package com.flyapi.web.controller;

import com.baidu.unbiz.fluentvalidator.FluentValidator;
import com.baidu.unbiz.fluentvalidator.Result;
import com.flyapi.core.base.BaseController;
import com.flyapi.core.constant.JSONResult;
import com.flyapi.core.id.SnowflakeIdWorker;
import com.flyapi.core.validator.NumberValidator;
import com.flyapi.core.validator.StringValidator;
import com.flyapi.model.*;
import com.flyapi.pojo.dto.AddArticleRequest;
import com.flyapi.service.api.*;
import com.flyapi.pojo.vo.ArticleDetailVo;
import com.flyapi.pojo.vo.ArticleSimpleVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import static com.baidu.unbiz.fluentvalidator.ResultCollectors.toSimple;

/**
 * author: flyhero
 * Date: 2017/6/19 0019 下午 2:17
 */
@Controller
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
    @Autowired
    private HomepageApplyService homepageApplyService;
    @Autowired
    private SnowflakeIdWorker snowflakeIdWorker;
    /**
     * Title: findArticleDetail
     * params: [articleId]
     * return: org.springframework.web.servlet.ModelAndView
     * author: flyhero(http://www.iflyapi.cn)
     * date: 2017/6/22 0022 上午 11:35
     */
    @RequestMapping(value = "article/detail/{articleId}", method = RequestMethod.GET)
    public ModelAndView findArticleDetail(@PathVariable("articleId") Long articleId) {

        if (isLogin()) {
            UcenterUser user = (UcenterUser) currentUser();
            userFameService.addFameValue(user.getUserId(), 4);
        }
        ArticleDetailVo detailVo = articleService.findArticleDetail(articleId);
        List<CmsComment> commentList = commentService.findCommentById(articleId);
        mv.addObject("detailVo", detailVo);
        mv.addObject("commentList", commentList);
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
    @GetMapping("article/list/{subjectId}/{title}")
    public ModelAndView findArticleBySubjectId(@PathVariable Long subjectId, @PathVariable String title) {
        List<CmsArticle> list = articleService.findArticleBySubjectId(subjectId);

        mv.addObject("articleList", list);
        mv.addObject("title", title);
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
    @RequestMapping("article/findArticleList")
    public JSONResult findArticleList(int pageNum, int pageSize) {
        PageInfo<ArticleSimpleVo> pageInfo = null;
        PageHelper.startPage(pageNum, pageSize);
        try {
            List<ArticleSimpleVo> list = articleService.findArticleSimple();
            pageInfo = new PageInfo<ArticleSimpleVo>(list);
        } catch (Exception ex) {
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
    @RequestMapping("article/findLastUpdateOrHotArticles")
    public JSONResult findLastUpdateOrHotArticles(int type) {
        logger.info("接收值：" + type);
        List<CmsArticle> list = null;
        try {
            list = articleService.findLastUpdateOrHotArticles(type);
        } catch (Exception e) {
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
    @RequestMapping("article/findArticleListByUserId/{userId}")
    public JSONResult findArticleListByUserId(@PathVariable long userId, int pageNum, int pageSize) {
        PageInfo<CmsArticle> pageInfo = null;
        PageHelper.startPage(pageNum, pageSize);
        try {
            List<CmsArticle> list = articleService.findArticleByUserId(userId);
            if (list == null || list.isEmpty()) {
                return JSONResult.error();
            }
            pageInfo = new PageInfo<CmsArticle>(list);
        } catch (Exception ex) {
            return JSONResult.error();
        }
        return JSONResult.ok(pageInfo);
    }

    /**
     * 前往添加编辑页
     *
     * @param articleId
     * @return org.springframework.web.servlet.ModelAndView
     * @title: gotoAddPage
     * @author qfwang
     * @date 2018/2/3 下午2:35
     */
    @GetMapping("article/{articleId}")
    public ModelAndView gotoAddPage(@PathVariable Long articleId) {


        mv.setViewName("article/add");

        UcenterUser user = (UcenterUser) currentUser();
        List<CmsSubject> subjectList = subjectService.findUserSubject(user.getUserId());
        if (subjectList == null || subjectList.size() == 0) {
            mv.addObject("tip", "请先创建主题,再写文章哦");
            return mv;
        }

        mv.addObject("subjectList", subjectList);

        CmsArticle article = articleService.selectByPrimaryKey(articleId);
        mv.addObject("article", article);

        return mv;

    }

    /**
     *
     * @title: addArticle
     * @author flyhero <http://www.iflyapi.cn>
     * @param addArticleRequest
     * @return com.flyapi.core.constant.JSONResult
     * @date 2018/2/8 上午12:20
     */
    @PostMapping("article")
    @ResponseBody
    public JSONResult addArticle(AddArticleRequest addArticleRequest) {
        Result result = FluentValidator.checkAll().on(addArticleRequest.getTitle(), new StringValidator(5, 15, "title"))
                .on(addArticleRequest.getApply().intValue(), new NumberValidator("申请"))
                .on(addArticleRequest.getMdContent(), new StringValidator("文章内容")).doValidate().result(toSimple());
        logger.info(result.toString());

        CmsArticle isExist = articleService.selectByPrimaryKey(addArticleRequest.getArticleId());
        CmsArticle cmsArticle = new CmsArticle();

        BeanUtils.copyProperties(addArticleRequest, cmsArticle);
        if(Objects.isNull(isExist)){
            cmsArticle.setArticleId(snowflakeIdWorker.nextId());
            //插入
            int num = articleService.insertSelective(cmsArticle);
            if (num > 0 && addArticleRequest.getStatus() !=0 && addArticleRequest.getApply() == 0) {
                CmsHomepageApply apply = new CmsHomepageApply();
                apply.setArticleId(cmsArticle.getArticleId());
                apply.setId(snowflakeIdWorker.nextId());
                apply.setCreateTime(new Date());
                homepageApplyService.insertSelective(apply);
            }

        }else {
            //更新
            articleService.updateByPrimaryKeySelective(cmsArticle);
        }

        return JSONResult.ok();
    }

}
