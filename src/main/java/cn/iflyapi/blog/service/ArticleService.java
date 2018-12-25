package cn.iflyapi.blog.service;

import cn.iflyapi.blog.annotation.OpLog;
import cn.iflyapi.blog.dao.ArticleMapper;
import cn.iflyapi.blog.dao.SubjectMapper;
import cn.iflyapi.blog.dao.custom.ArticleCustomMapper;
import cn.iflyapi.blog.entity.*;
import cn.iflyapi.blog.enums.CodeMsgEnum;
import cn.iflyapi.blog.enums.OperationEnum;
import cn.iflyapi.blog.enums.OrderbyEnum;
import cn.iflyapi.blog.exception.FlyapiException;
import cn.iflyapi.blog.pojo.po.ArticleStats;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;

/**
 * @author flyhero
 * @date 2018/12/16 6:52 PM
 */
@Service
public class ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private SubjectMapper subjectMapper;

    @Autowired
    private ArticleCustomMapper articleCustomMapper;

    public List<Article> listArticle(Long subjectId, Long userId) {
        SubjectExample subjectExample = new SubjectExample();
        subjectExample.createCriteria().andSubjectIdEqualTo(subjectId).andUserIdEqualTo(userId);
        boolean isOwn = subjectMapper.countByExample(subjectExample) > 0;
        if (!isOwn) {
            Subject subject = subjectMapper.selectByPrimaryKey(subjectId);
            if (Objects.isNull(subject) || subject.getIsDelete()) {
                throw new FlyapiException(CodeMsgEnum.RESOURCE_NOT_EXIST);
            }
            if (subject.getIsPrivate()) {
                throw new FlyapiException(CodeMsgEnum.RESOURCE_FORBIDDEN);
            }
        }
        ArticleExample articleExample = new ArticleExample();
        articleExample.createCriteria().andSubjectIdEqualTo(subjectId).andIsDeleteEqualTo(false);
        return articleMapper.selectByExample(articleExample);
    }

    @OpLog(op = OperationEnum.ARTICLE_READ, score = 2)
    public ArticleWithBLOBs readArticle(Long articleId) {
        ArticleWithBLOBs articleWithBLOBs = articleMapper.selectByPrimaryKey(articleId);
        if (Objects.isNull(articleWithBLOBs) || articleWithBLOBs.getIsDelete()) {
            throw new FlyapiException(CodeMsgEnum.RESOURCE_NOT_EXIST);
        }
        articleCustomMapper.addNum(ArticleStats.view(articleId));
        return articleWithBLOBs;
    }

    public void countLike(Long articleId) {
        articleCustomMapper.addNum(ArticleStats.like(articleId));
    }

    public void countComment(Long articleId) {
        articleCustomMapper.addNum(ArticleStats.comment(articleId));
    }

    public Page<Article> listPageAticles(String title, int orderby, int pageNum, int pageSize) {
        ArticleExample articleExample = new ArticleExample();
        if (!StringUtils.isEmpty(title)) {
            articleExample.createCriteria().andTitleLike("%" + title + "%").andIsDeleteEqualTo(false);
            articleExample.setOrderByClause("create_time desc");
        } else {
            if (OrderbyEnum.CREATETIME.getCode() == orderby) {
                articleExample.setOrderByClause("create_time desc");
            } else if (OrderbyEnum.HOT.getCode() == orderby) {
                articleExample.setOrderByClause("like_num,comment_num,view_num desc");
            } else if (OrderbyEnum.PREDICTION.getCode() == orderby) {

            }
        }
        return PageHelper.startPage(pageNum, pageSize)
                .doSelectPage(() -> articleMapper.selectByExample(articleExample));
    }

    public boolean remove(Long articleId) {
        ArticleWithBLOBs article = new ArticleWithBLOBs();
        article.setArticleId(articleId);
        article.setIsDelete(true);
        return articleMapper.updateByPrimaryKeySelective(article) > 0;
    }
}
