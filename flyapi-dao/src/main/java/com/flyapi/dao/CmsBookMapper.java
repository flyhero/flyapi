package com.flyapi.dao;

import com.flyapi.model.CmsBook;
import com.flyapi.pojo.vo.BookVo;

import java.util.List;


public interface CmsBookMapper {

    int deleteByPrimaryKey(Long bookId);

    int insert(CmsBook record);

    int insertSelective(CmsBook record);


    CmsBook selectByPrimaryKey(Long bookId);


    int updateByPrimaryKeySelective(CmsBook record);

    int updateByPrimaryKey(CmsBook record);

    List<BookVo> findBookList();

    Long findCount();
}