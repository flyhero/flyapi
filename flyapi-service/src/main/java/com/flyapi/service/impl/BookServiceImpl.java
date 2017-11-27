package com.flyapi.service.impl;

import com.flyapi.core.base.BaseServiceImpl;
import com.flyapi.dao.CmsBookMapper;
import com.flyapi.model.CmsBook;
import com.flyapi.pojo.vo.BookVo;
import com.flyapi.service.api.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Author: qfwang
 * Date: 2017-11-24 下午3:24
 */
@Service
@Transactional
public class BookServiceImpl extends BaseServiceImpl<CmsBook,CmsBookMapper> implements BookService{

    @Autowired
    private CmsBookMapper cmsBookMapper;
    public List<BookVo> findBookList() {
        return cmsBookMapper.findBookList();
    }
    public Long findCount(){
        return cmsBookMapper.findCount();
    }
}
