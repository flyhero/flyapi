package com.flyapi.web.controller;

import com.flyapi.core.constant.JSONResult;
import com.flyapi.model.CmsComment;
import com.flyapi.service.api.CommentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Author: qfwang
 * Date: 2017-11-1 上午11:13
 */
@Controller
public class CommentController {
    @Autowired
    private CommentService commentService;

    /**
     * 获取评论列表
     * @title: findCommentList
     * @author qfwang
     * @params [pageNum, pageSize, articleId]
     * @return com.flyapi.core.constant.JSONResult
     * @date 2017/11/1 下午5:57
     */
    @ResponseBody
    @GetMapping("comment/{articleId}")
    public JSONResult findCommentList(int pageNum, int pageSize, @PathVariable long articleId){

        PageInfo<CmsComment> pageInfo = null;
        PageHelper.startPage(pageNum, pageSize);
        try{
            List<CmsComment> list = commentService.findCommentById(articleId);
            pageInfo = new PageInfo<CmsComment>(list);
        }catch (Exception ex){
            return JSONResult.error();
        }

        return JSONResult.ok(pageInfo);
    }
}
