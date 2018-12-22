package cn.iflyapi.blog.controller;

import cn.iflyapi.blog.annotation.OpenApi;
import cn.iflyapi.blog.entity.Article;
import cn.iflyapi.blog.entity.ArticleWithBLOBs;
import cn.iflyapi.blog.model.JSONResult;
import cn.iflyapi.blog.service.ArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author flyhero
 * @date 2018/12/16 7:39 PM
 */
@Api(value = "ArticleController", tags = "文章接口")
@RestController
public class ArticleController extends BaseController {

    @Autowired
    private ArticleService articleService;

    @OpenApi("/subjects/*/articles")
    @ApiOperation("查询指定小书下所有文章")
    @GetMapping("/subjects/{subjectId}/articles")
    public JSONResult findSubjectAticle(@PathVariable Long subjectId) {
        return JSONResult.ok(articleService.listArticle(subjectId, getUserId()));
    }

    @OpenApi("/articles/*")
    @ApiOperation("查询指定文章详情")
    @GetMapping("/articles/{articleId}")
    public JSONResult findAticle(@PathVariable Long articleId) {
        ArticleWithBLOBs article = articleService.findArticle(articleId);
        //TODO 记录用户查看的文章 用户分析推荐

        return JSONResult.ok(article);
    }


    /**
     *
     * @param title
     * @param orderby {@link cn.iflyapi.blog.enums.OrderbyEnum}
     * @param pageNum
     * @param pageSize
     * @return
     */
    @OpenApi("/articles")
    @ApiOperation(value = "查询文章列表", notes = "1.根据日期倒序 2.根据评论，点赞等 3.根据用户喜好")
    @GetMapping("/articles")
    public JSONResult findAticles(String title, int orderby, int pageNum, int pageSize) {
        return JSONResult.ok(articleService.listPageAticles(title, orderby, pageNum, pageSize));
    }

}
