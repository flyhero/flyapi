package com.flyapi.service.api;

import com.flyapi.core.base.BaseService;
import com.flyapi.model.CmsBook;
import com.flyapi.pojo.vo.BookVo;

import java.util.List;

/**
 * Author: qfwang
 * Date: 2017-11-24 下午3:22
 */
public interface BookService extends BaseService<CmsBook>{

    List<BookVo> findBookList();
    Long findCount();
}
