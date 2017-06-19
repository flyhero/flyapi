package com.flyapi.web.controller;

import com.flyapi.core.base.BaseController;
import com.flyapi.model.CmsArticle;
import com.flyapi.model.UcenterUser;
import com.flyapi.service.api.ArticleService;
import com.flyapi.service.api.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * author: flyhero
 * Date: 2017/6/19 0019 下午 2:17
 */
@Controller
@RequestMapping("article")
public class ArticleController extends BaseController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "detail/{articleId}",method = RequestMethod.GET)
    public ModelAndView findArticleDetail(@PathVariable("articleId")Long articleId){
        CmsArticle article = articleService.selectByPrimaryKey(articleId);

        CmsArticle cmsArticle= new CmsArticle();
        cmsArticle.setArticleId(articleId);
        cmsArticle.setViewNum(1);
        articleService.updateCommentNumOrLikeNumOrViewNum(cmsArticle);

        UcenterUser user=userService.selectByPrimaryKey(article.getUserId());

        mv.addObject("article",article);
        mv.addObject("user",user);
        mv.setViewName("html/article/detail");
        return mv;
    }

}
