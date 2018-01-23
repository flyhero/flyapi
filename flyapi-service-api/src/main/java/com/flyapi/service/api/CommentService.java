package com.flyapi.service.api;

import com.flyapi.core.base.BaseService;
import com.flyapi.model.CmsComment;
import com.flyapi.model.UcenterUser;
import com.flyapi.pojo.vo.CommentVo;

import java.util.List;

/**
 * author: flyhero
 * Date: 2017/6/9 0009 下午 3:57
 */
public interface CommentService extends BaseService<CmsComment> {

    List<CmsComment> findCommentById(long targetId);

    List<CommentVo> findCommentByAuthorId(Long authorId);

}
