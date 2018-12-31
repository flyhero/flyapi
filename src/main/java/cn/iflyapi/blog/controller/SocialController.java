package cn.iflyapi.blog.controller;

import cn.iflyapi.blog.entity.Social;
import cn.iflyapi.blog.model.JSONResult;
import cn.iflyapi.blog.service.SocialService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author flyhero
 * @date 2018-12-31 8:03 PM
 */
@Api(value = "SocialController", tags = "社交接口")
@RestController
public class SocialController extends BaseController {

    @Autowired
    private SocialService socialService;

    @ApiOperation("查询")
    @GetMapping("/socials")
    public JSONResult find() {
        return JSONResult.ok(socialService.listSocial(getUserId()));
    }


    @ApiOperation("新增/修改")
    @PostMapping("/socials")
    public JSONResult add(@RequestBody Social socials) {
        socialService.update(socials);
        return JSONResult.ok();
    }

    @ApiOperation("删除")
    @DeleteMapping("/socials/{/socialId}")
    public JSONResult remove(@PathVariable Long socialId){
        socialService.remove(socialId);
        return JSONResult.ok();
    }
}
