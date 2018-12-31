package cn.iflyapi.blog.controller;

import cn.iflyapi.blog.entity.Store;
import cn.iflyapi.blog.model.JSONResult;
import cn.iflyapi.blog.service.StoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author flyhero
 * @date 2018-12-31 2:32 PM
 */
@Api(value = "StoreController", tags = "图床接口")
@RestController
public class StoreController extends BaseController {

    @Autowired
    private StoreService storeService;

    @ApiOperation("查询图床")
    @GetMapping("/stores")
    public JSONResult find() {
        return JSONResult.ok(storeService.get(getUserId()));
    }

    @ApiOperation("修改图床")
    @PatchMapping("/stores/{storeId}")
    public JSONResult update(@PathVariable Long storeId, @RequestBody Store store) {
        store.setId(storeId);
        return JSONResult.ok(storeService.update(store));
    }
}
