package com.flyapi.service.impl;

import com.flyapi.core.base.BaseServiceImpl;
import com.flyapi.core.id.SnowflakeIdWorker;
import com.flyapi.dao.CmsArticleMapper;
import com.flyapi.dao.CmsCommentMapper;
import com.flyapi.dao.CmsReplyMapper;
import com.flyapi.model.CmsArticle;
import com.flyapi.model.CmsComment;
import com.flyapi.model.CmsReply;
import com.flyapi.pojo.dto.CommentDto;
import com.flyapi.pojo.vo.CommentVo;
import com.flyapi.service.api.ArticleService;
import com.flyapi.service.api.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * author: flyhero
 * Date: 2017/6/9 0009 下午 3:58
 */
@Service
@Transactional
public class CommentServiceImpl extends BaseServiceImpl<CmsComment,CmsCommentMapper> implements CommentService {

    @Autowired
    private CmsCommentMapper cmsCommentMapper;
    @Autowired
    private CmsReplyMapper cmsReplyMapper;
    @Autowired
    private SnowflakeIdWorker idWorker;


    public List<CmsComment> findCommentById(long targetId) {
        return cmsCommentMapper.findCommentById(targetId);
    }

    public List<CommentVo> findCommentByAuthorId(Long authorId) {
        return cmsCommentMapper.findCommentByAuthorId(authorId);
    }

    @Override
    public int comment(CommentDto commentDto,Long userId) {
        int num=0;
        if(commentDto.getCommentId() == 0){
            CmsComment cmsComment = new CmsComment();
            cmsComment.setCommentId(idWorker.nextId());
            cmsComment.setTargetId(commentDto.getArticleId());
            cmsComment.setTargetType((byte)1);
            cmsComment.setAuthorId(commentDto.getAuthorId());
            cmsComment.setUserId(userId);
            cmsComment.setContent(commentDto.getContent());
            cmsComment.setCreateTime(new Date());
            num = cmsCommentMapper.insertSelective(cmsComment);
        }else {
            CmsReply reply = new CmsReply();
            reply.setReplyId(idWorker.nextId());
            reply.setCommentId(commentDto.getCommentId());
            reply.setContent(commentDto.getContent());
            reply.setFromUserId(userId);
            reply.setCreateTime(new Date());
            num = cmsReplyMapper.insertSelective(reply);
        }
        return num;
    }

    @Override
    public boolean readComment(Long commentId,Long userId) {
        CmsComment cmsComment = new CmsComment();
        if(commentId != null && commentId != 0){
            cmsComment.setCommentId(commentId);
        }
        cmsComment.setUserId(userId);
        int num = cmsCommentMapper.updateRead(cmsComment);
        return num>0 ? true:false;
    }
}
