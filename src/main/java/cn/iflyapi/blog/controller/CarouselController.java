package cn.iflyapi.blog.controller;

import cn.iflyapi.blog.annotation.OpenApi;
import cn.iflyapi.blog.entity.Carousel;
import cn.iflyapi.blog.model.JSONResult;
import cn.iflyapi.blog.service.CarouselService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author flyhero
 * @date 2018-12-31 11:14 AM
 */
@Api(value = "CarouselController", tags = "轮播图接口")
@RestController
public class CarouselController {

    @Autowired
    private CarouselService carouselService;

    @ApiOperation("查询轮播图")
    @OpenApi("/carousels")
    @GetMapping("/carousels")
    public JSONResult find() {
        return JSONResult.ok(carouselService.listCarousel());
    }

    @ApiOperation("新增轮播图")
    @PostMapping("/carousels")
    public JSONResult add(@RequestBody Carousel carousel) {
        carouselService.save(carousel);
        return JSONResult.ok();
    }

    @ApiOperation("修改轮播图")
    @PatchMapping("/carousels/{carouselId}")
    public JSONResult update(@PathVariable Long carouselId, @RequestBody Carousel carousel) {
        carousel.setId(carouselId);
        carouselService.update(carousel);
        return JSONResult.ok();
    }

    @ApiOperation("删除轮播图")
    @DeleteMapping("/carousels/{carouselId}")
    public JSONResult remove(@PathVariable Long carouselId) {
        carouselService.remove(carouselId);
        return JSONResult.ok();
    }

}
