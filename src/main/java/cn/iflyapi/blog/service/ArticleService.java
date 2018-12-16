package cn.iflyapi.blog.service;

import cn.iflyapi.blog.dao.ArticleDao;
import cn.iflyapi.blog.dao.SubjectDao;
import cn.iflyapi.blog.entity.Article;
import cn.iflyapi.blog.entity.Subject;
import cn.iflyapi.blog.enums.CodeMsgEnum;
import cn.iflyapi.blog.exception.FlyapiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * author flyhero
 * date 2018/12/16 6:52 PM
 */
@Service
public class ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private SubjectDao subjectDao;

    public List<Article> listArticle(Long subjectId, Long userId) {
        boolean isOwn = subjectDao.existsSubjectBySubjectIdAndUserId(subjectId, userId);
        if (!isOwn) {
            Subject subject = subjectDao.getOne(subjectId);
            if (Objects.isNull(subject)) {
                throw new FlyapiException(CodeMsgEnum.RESOURCE_NOT_EXIST);
            }
            if (subject.getIsPrivate()) {
                throw new FlyapiException(CodeMsgEnum.RESOURCE_FORBIDDEN);
            }
        }
        return articleDao.findArticlesBySubjectIdAndIsDelete(subjectId, false);
    }

    public boolean remove(Long articleId) {
        return articleDao.remove(articleId);
    }
}
