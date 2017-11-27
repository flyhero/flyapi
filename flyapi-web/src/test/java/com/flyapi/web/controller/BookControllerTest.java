package com.flyapi.web.controller;

import com.flyapi.pojo.vo.BookVo;
import com.flyapi.service.api.BookService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * User: qfwang
 * Date: 2017-09-25
 * Time: 下午6:05
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/spring/*.xml"})
public class BookControllerTest {

    @Autowired
    private BookService bookService;

    @Test
    public void testFindBookList(){
        List<BookVo> list = bookService.findBookList();
        Assert.assertNotNull(list);
    }
}
