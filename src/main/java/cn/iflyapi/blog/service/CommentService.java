package cn.iflyapi.blog.service;

import cn.iflyapi.blog.dao.CommentMapper;
import cn.iflyapi.blog.entity.Comment;
import cn.iflyapi.blog.entity.CommentExample;
import cn.iflyapi.blog.enums.CodeMsgEnum;
import cn.iflyapi.blog.exception.FlyapiException;
import cn.iflyapi.blog.pojo.dto.CommentDto;
import cn.iflyapi.blog.util.SnowflakeIdWorker;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author flyhero
 * @date 2019-01-05 11:24 AM
 */
@Service
public class CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private SnowflakeIdWorker idWorker;

    /**
     * 添加评论
     *
     * @param commentDto
     */
    public void comment(CommentDto commentDto) {
        Comment comment = new Comment();
        BeanUtils.copyProperties(commentDto, comment);
        comment.setCommentId(idWorker.nextId());
        comment.setCreateTime(new Date());
        commentMapper.insertSelective(comment);
    }

    /**
     * 删除评论
     *
     * @param commentId
     */
    public void remove(Long commentId, Long currentUserId) {
        CommentExample commentExample = new CommentExample();
        commentExample.createCriteria().andUserIdEqualTo(currentUserId).andCommentIdEqualTo(commentId).andIsDeleteEqualTo(false);
        long num = commentMapper.countByExample(commentExample);
        if (num < 1) {
            throw new FlyapiException(CodeMsgEnum.RESOURCE_FORBIDDEN);
        }
        Comment comment = new Comment();
        comment.setCommentId(commentId);
        comment.setIsDelete(true);
        commentMapper.updateByPrimaryKeySelective(comment);
    }

    /**
     * 当前用户的评论
     *
     * @param userId
     * @return
     */
    public List<Comment> listComment(Long userId, int type) {
        CommentExample commentExample = new CommentExample();
        CommentExample.Criteria criteria = commentExample.createCriteria();
        criteria.andIsDeleteEqualTo(false).andAuthorIdEqualTo(userId);
        if (type == 0) {
            criteria.andIsReadEqualTo(false);
        } else if (type == 1) {
            criteria.andIsReadEqualTo(true);
        }
        commentExample.setOrderByClause("create_time desc");
        return commentMapper.selectByExampleWithBLOBs(commentExample);
    }

    /**
     * 已读某评论
     *
     * @param commentId
     */
    public void readComment(Long commentId) {
        Comment comment = new Comment();
        comment.setCommentId(commentId);
        comment.setIsRead(true);
        commentMapper.updateByPrimaryKeySelective(comment);
    }

    /**
     * 标记全部已读
     *
     * @param userId
     */
    public void clearUnread(Long userId) {
        CommentExample commentExample = new CommentExample();
        commentExample.createCriteria().andAuthorIdEqualTo(userId).andIsReadEqualTo(false).andIsDeleteEqualTo(false);
        Comment comment = new Comment();
        comment.setIsRead(true);
        commentMapper.updateByExampleSelective(comment, commentExample);
    }

}
