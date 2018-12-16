package cn.iflyapi.blog.controller;

import cn.iflyapi.blog.entity.Subject;
import cn.iflyapi.blog.model.JSONResult;
import cn.iflyapi.blog.service.SubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 
 * @author flyhero
 * @date 2018/12/16 7:39 PM
 */
@Api(value = "UserController", tags = "小书接口")
@RestController
public class SubjectController extends BaseController {

    @Autowired
    private SubjectService subjectService;

    @ApiOperation("查询指定用户的小书")
    @GetMapping("/users/{userId}/subjects")
    public JSONResult find(@PathVariable Long userId) {
        return JSONResult.ok(subjectService.listSubject(userId, getUserId()));
    }

    @ApiOperation("增加小书")
    @PostMapping("/subjects")
    public JSONResult add(@RequestBody Subject subject) {
        return JSONResult.ok(subjectService.save(subject));
    }
}
