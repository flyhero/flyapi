package cn.iflyapi.blog.controller;

import cn.iflyapi.blog.enums.CodeMsgEnum;
import cn.iflyapi.blog.exception.FlyapiException;
import cn.iflyapi.blog.model.JSONResult;
import cn.iflyapi.blog.pojo.dto.CommentDto;
import cn.iflyapi.blog.service.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author flyhero
 * @date 2019-01-05 11:56 AM
 */
@Api(value = "CommentController", tags = "评论接口")
@RestController
public class CommentController extends BaseController {

    @Autowired
    private CommentService commentService;

    @ApiOperation("新增评论")
    @PostMapping("/comments")
    public JSONResult add(@RequestBody CommentDto commentDto) {
        commentService.comment(commentDto);
        return JSONResult.ok();
    }

    @ApiOperation("删除我的评论")
    @DeleteMapping("/comments/{commentId}")
    public JSONResult remove(@PathVariable Long commentId) {
        commentService.remove(commentId, getUserId());
        return JSONResult.ok();
    }

    @ApiOperation("读了评论")
    @PatchMapping("/comments/{commentId}")
    public JSONResult read(@PathVariable Long commentId) {
        commentService.readComment(commentId);
        return JSONResult.ok();
    }

    @ApiOperation(value = "查询我的评论", notes = "type 0 未读 1 已读 2 全部")
    @GetMapping("/users/{userId}/comments")
    public JSONResult find(@PathVariable Long userId, int type) {
        if (!userId.equals(getUserId())) {
            throw new FlyapiException(CodeMsgEnum.RESOURCE_FORBIDDEN);
        }
        return JSONResult.ok(commentService.listComment(userId, type));
    }

    @ApiOperation("标记全部已读")
    @PatchMapping("/users/{userId}/comments")
    public JSONResult clear(@PathVariable Long userId) {
        if (!userId.equals(getUserId())) {
            throw new FlyapiException(CodeMsgEnum.RESOURCE_FORBIDDEN);
        }
        commentService.clearUnread(userId);
        return JSONResult.ok();
    }
}
