package com.flyapi.web.controller;

import com.baidu.unbiz.fluentvalidator.FluentValidator;
import com.baidu.unbiz.fluentvalidator.Result;
import com.flyapi.core.base.BaseController;
import com.flyapi.core.constant.JSONResult;
import com.flyapi.core.constant.TipsEnum;
import com.flyapi.core.id.SnowflakeIdWorker;
import com.flyapi.core.validator.NumberValidator;
import com.flyapi.core.validator.StringValidator;
import com.flyapi.model.*;
import com.flyapi.pojo.dto.AddArticleRequest;
import com.flyapi.pojo.vo.ArticleCollectVo;
import com.flyapi.pojo.vo.ArticleDetailVo;
import com.flyapi.pojo.vo.ArticleSimpleVo;
import com.flyapi.pojo.vo.ShowCommentVo;
import com.flyapi.service.api.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
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
    @Autowired
    private CollectArticleService collectArticleService;
    @Autowired
    private LikeService likeService;
    @Autowired
    private FameService fameService;
    /**
     * Title: findArticleDetail
     * params: [articleId]
     * return: org.springframework.web.servlet.ModelAndView
     * author: flyhero(http://www.iflyapi.cn)
     * date: 2017/6/22 0022 上午 11:35
     */
    @RequestMapping(value = "article/detail/{articleId}", method = RequestMethod.GET)
    public ModelAndView findArticleDetail(@PathVariable("articleId") Long articleId) {
        logger.info("findArticleDetail|查询文章详情，articleId={}",articleId);
        boolean isLike = false;
        int isCollection = 0;
        if (isLogin()) {
            UcenterUser user = (UcenterUser) currentUser();
            userFameService.addFameValue(user.getUserId(), 4);
            CmsLike requestLike = new CmsLike();
            requestLike.setUserId(user.getUserId());
            requestLike.setTargetId(articleId);
            requestLike.setTargetType((byte)1);
            CmsLike like = likeService.findByUserIdAndTargetId(requestLike);
            isCollection = collectArticleService.findIsCollectionByArticleId(articleId,user.getUserId());
            if(like != null && like.getIsDelete() == 0){
                isLike = true;
            }

        }
        ArticleDetailVo detailVo = articleService.findArticleDetail(articleId);
        List<ShowCommentVo> commentList = commentService.findCommentById(articleId);
        UcenterFame fame =fameService.findByFameValue(detailVo.getUser().getFameValue());

        mv.addObject("detailVo", detailVo);
        mv.addObject("commentList", commentList);
        mv.addObject("isLike", isLike);
        mv.addObject("isCollection", isCollection);
        mv.addObject("fame", fame);
        mv.setViewName("article/detail");
        return mv;
    }
    /**
     * 点赞
     * @title: doLike
     * @param articleId
     * @return com.flyapi.core.constant.JSONResult
     * @date 2018/3/4 下午4:18
     */
    @PostMapping("article/{articleId}/like")
    @ResponseBody
    public JSONResult doLike(@PathVariable Long articleId){
        boolean isLike = false;
        UcenterUser user = (UcenterUser) currentUser();
        if (user == null) {
            return JSONResult.error("未登录");
        }
        CmsLike like = new CmsLike();
        like.setId(snowflakeIdWorker.nextId());
        like.setUserId(user.getUserId());
        like.setTargetType((byte)1);
        like.setTargetId(articleId);
        CmsLike like1 = likeService.findByUserIdAndTargetId(like);

        CmsArticle article = new CmsArticle();
        article.setArticleId(articleId);

        if(like1 == null){
            likeService.insertSelective(like);
            isLike = true;
            // 文章点赞数加1
            article.setLikeNum(1);
        }else {
            if(like1.getIsDelete() == 0){
                like1.setIsDelete((byte)1);
                isLike = false;
                // 文章点赞数减1
                article.setLikeNum(0);
            }else {
                like1.setIsDelete((byte)0);
                isLike = true;
                // 文章点赞数加1
                article.setLikeNum(1);
            }
            likeService.updateByPrimaryKeySelective(like1);

        }
        articleService.updateLikeNum(article);
        return JSONResult.ok(isLike);
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
        CmsSubject subject = subjectService.selectByPrimaryKey(subjectId);
        mv.addObject("articleList", list);
        mv.addObject("title", title);
        mv.addObject("subject", subject);
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
    @GetMapping("article/user")
    public JSONResult findArticleListByUserId( int pageNum, int pageSize) {
        PageInfo<CmsArticle> pageInfo = null;
        PageHelper.startPage(pageNum, pageSize);
        try {
            UcenterUser user = (UcenterUser) currentUser();
            List<CmsArticle> list = articleService.findArticleByUserId(user.getUserId());
            if (list == null || list.isEmpty()) {
                return JSONResult.error();
            }
            pageInfo = new PageInfo<CmsArticle>(list);
        } catch (Exception ex) {
            return JSONResult.error();
        }
        return JSONResult.ok(pageInfo);
    }

    @ResponseBody
    @GetMapping("article/count")
    public JSONResult findArticleCountByUserId(){
        UcenterUser user = (UcenterUser) currentUser();
        int num= articleService.findArticleCountByUserId(user.getUserId());
        return JSONResult.ok(num);
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

        CmsApply apply = homepageApplyService.findByArticleId(articleId);
        mv.addObject("subjectList", subjectList);

        CmsArticle article = articleService.selectByPrimaryKey(articleId);
        if(article != null && apply != null){
            mv.addObject("isApply",false);
        }else {
            mv.addObject("isApply",true);
        }

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
        logger.info("addArticle|参数：{}",addArticleRequest.toString());

        try {
            CmsArticle isExist = articleService.selectByPrimaryKey(addArticleRequest.getArticleId());
            CmsArticle cmsArticle = new CmsArticle();

            BeanUtils.copyProperties(addArticleRequest, cmsArticle);
            if(Objects.isNull(isExist)){
                cmsArticle.setArticleId(snowflakeIdWorker.nextId());
                UcenterUser user = (UcenterUser) currentUser();
                if(user == null){
                    return JSONResult.error("请登录");
                }
                cmsArticle.setUserId(user.getUserId());
                //插入
                int num = articleService.insertSelective(cmsArticle);
                if (num > 0 && addArticleRequest.getStatus() !=0 && addArticleRequest.getApply() == 0) {
                    logger.info("addArticle|发布文章成功");
                    CmsApply apply = new CmsApply();
                    apply.setArticleId(cmsArticle.getArticleId());
                    apply.setId(snowflakeIdWorker.nextId());
                    apply.setCreateTime(new Date());
                    homepageApplyService.insertSelective(apply);
                }

            }else {
                logger.info("addArticle|已存在文章，进行更新");
                //更新
                articleService.updateByPrimaryKeySelective(cmsArticle);
            }
        } catch (Exception e) {
            System.out.println("addArticle|异常："+e.toString());
            logger.error("addArticle|异常：{}",e.toString());
            e.printStackTrace();
        }

        return JSONResult.ok();
    }

    /**
     * 获取收藏的文章
     * @title: findCollectArticle
     * @param pageNum
     * @param pageSize
     * @return com.flyapi.core.constant.JSONResult
     * @date 2018/2/27 下午10:53
     */
    @ResponseBody
    @GetMapping("article/collection")
    public JSONResult findCollectArticle(int pageNum, int pageSize){
        PageInfo<ArticleCollectVo> pageInfo = null;
        PageHelper.startPage(pageNum, pageSize);
        UcenterUser user = (UcenterUser) currentUser();
        if(user == null){
            return JSONResult.error(TipsEnum.NOT_LOGIN);
        }
        List<ArticleCollectVo> articleCollectVoList = collectArticleService.findArticleByUserId(user.getUserId());
        pageInfo = new PageInfo<ArticleCollectVo>(articleCollectVoList);
        return JSONResult.ok(pageInfo);
    }
    @ResponseBody
    @GetMapping("article/collection/count")
    public JSONResult findCollectArticleCount(){
        UcenterUser user = (UcenterUser) currentUser();
        int num= collectArticleService.findCollectionCount(user.getUserId());
        return JSONResult.ok(num);
    }

    /**
     * 收藏文章
     * @param articleId
     * @return
     */
    @ResponseBody
    @PostMapping("article/collection")
    public JSONResult addCollectArticle(Long articleId){
        CmsCollectArticle cmsCollectArticle = new CmsCollectArticle();
        UcenterUser user = (UcenterUser) currentUser();
        if(null == user){
            return JSONResult.error(TipsEnum.NOT_LOGIN);
        }
        cmsCollectArticle.setArticleId(articleId);
        cmsCollectArticle.setUserId(user.getUserId());
        cmsCollectArticle.setId(snowflakeIdWorker.nextId());
        cmsCollectArticle.setCreateTime(new Date());
        collectArticleService.insertSelective(cmsCollectArticle);
        return JSONResult.ok();
    }
}
