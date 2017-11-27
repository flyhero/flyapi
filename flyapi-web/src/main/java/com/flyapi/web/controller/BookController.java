package com.flyapi.web.controller;

import com.flyapi.core.base.BaseController;
import com.flyapi.core.constant.JSONResult;
import com.flyapi.model.CmsBook;
import com.flyapi.pojo.vo.BookVo;
import com.flyapi.service.api.BookService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Author: qfwang
 * Date: 2017-11-24 下午3:33
 */
@Controller
@RequestMapping("book")
public class BookController extends BaseController{
    @Autowired
    private BookService bookService;

    /**
     *
     * @title: findBooks
     * @author flyhero <http://www.iflyapi.cn>
     * @params [pageNum, pageSize]
     * @return com.flyapi.core.constant.JSONResult
     * @date 2017/11/27 上午10:23
     */
    @RequestMapping("books")
    @ResponseBody
    public JSONResult findBooks(int pageNum,int pageSize){

        PageInfo<BookVo> pageInfo = null;
        PageHelper.startPage(pageNum, pageSize);
        try{
            List<BookVo> list = bookService.findBookList();
            pageInfo = new PageInfo<BookVo>(list);
        }catch (Exception ex){
            return JSONResult.error();
        }
        return JSONResult.ok(pageInfo);
    }
    /**
     * 获取书籍总数
     * @title: findBookCount
     * @author flyhero <http://www.iflyapi.cn>
     * @params []
     * @return com.flyapi.core.constant.JSONResult
     * @date 2017/11/27 下午3:08
     */
    @RequestMapping("count")
    @ResponseBody
    public JSONResult findBookCount(){

        long count = 0;
        try{
            count = bookService.findCount();
        }catch (Exception ex){
            return JSONResult.error();
        }
        return JSONResult.ok(count);
    }
}
