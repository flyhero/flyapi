package cn.iflyapi.blog.controller;

import cn.iflyapi.blog.entity.Subject;
import cn.iflyapi.blog.model.JSONResult;
import cn.iflyapi.blog.service.SubjectService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: qfwang
 * @date: 2018-12-16 4:56 PM
 */
@RestController
public class SubjectController extends BaseController{

    @Autowired
    private SubjectService subjectService;

    @ApiOperation("查询当前用户的所有小书")
    @GetMapping("/subjects")
    public JSONResult find(){
        return JSONResult.ok(subjectService.listSubject(getUserId()));
    }

    @ApiOperation("增加小书")
    @PostMapping("/subjects")
    public JSONResult add(@RequestBody Subject subject){
        try{
            subjectService.save(subject);
        }catch(Exception e){
            return JSONResult.fail();
        }
        return JSONResult.ok();
    }
}
