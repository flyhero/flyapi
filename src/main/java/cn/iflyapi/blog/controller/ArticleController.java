package cn.iflyapi.blog.controller;

import cn.iflyapi.blog.annotation.OpenApi;
import cn.iflyapi.blog.entity.ArticleWithBLOBs;
import cn.iflyapi.blog.model.JSONResult;
import cn.iflyapi.blog.pojo.dto.ArticleDto;
import cn.iflyapi.blog.service.ArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public JSONResult findSubjectArticle(@PathVariable Long subjectId) {
        return JSONResult.ok(articleService.listArticle(subjectId, getUserId()));
    }

    @OpenApi("/user/*/articles/rank")
    @ApiOperation("查询指定用户的文章排行")
    @GetMapping("/users/{userId}/articles/rank")
    public JSONResult findUserArticle(@PathVariable Long userId, int type) {
        return JSONResult.ok();
    }

    @OpenApi("/articles/*")
    @ApiOperation("查询指定文章详情")
    @GetMapping("/articles/{articleId}")
    public JSONResult findArticle(@PathVariable Long articleId) {
        ArticleWithBLOBs article = articleService.readArticle(articleId);
        return JSONResult.ok(article);
    }

    @ApiOperation("删除文章")
    @DeleteMapping("/articles/{articleId}")
    public JSONResult remove(@PathVariable Long articleId) {
        articleService.remove(articleId);
        return JSONResult.ok();
    }


    @ApiOperation("点赞文章")
    @PatchMapping("/articles/{articleId}/likes")
    public JSONResult like(@PathVariable Long articleId) {
        articleService.countLike(articleId);
        return JSONResult.ok();
    }

    /**
     * @param title
     * @param orderby  {@link cn.iflyapi.blog.enums.OrderbyEnum}
     * @param pageNum
     * @param pageSize
     * @return
     */
    @OpenApi("/articles")
    @ApiOperation(value = "查询文章列表", notes = "1.根据日期倒序 2.根据评论，点赞等 3.根据用户喜好")
    @GetMapping("/articles")
    public JSONResult findArticles(String title, int orderby, int pageNum, int pageSize) {
        return JSONResult.ok(articleService.listPageAticles(title, orderby, getUserId(), pageNum, pageSize));
    }

    @ApiOperation("保存文章")
    @PostMapping("/articles")
    public JSONResult save(@RequestBody ArticleDto articleDto) {
        articleService.save(articleDto, getUserId());
        return JSONResult.ok();
    }
}
