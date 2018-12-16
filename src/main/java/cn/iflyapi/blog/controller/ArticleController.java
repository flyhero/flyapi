package cn.iflyapi.blog.controller;

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

    @ApiOperation("查询指定小书下所有文章")
    @GetMapping("/subjects/{subjectId}/articles")
    public JSONResult findSubjectAticle(@PathVariable Long subjectId) {
        return JSONResult.ok(articleService.listArticle(subjectId, getUserId()));
    }
}
