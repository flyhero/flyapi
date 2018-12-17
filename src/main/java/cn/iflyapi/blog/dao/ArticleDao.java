package cn.iflyapi.blog.dao;

import cn.iflyapi.blog.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * author flyhero
 * date 2018/12/16 6:49 PM
 */
@Repository
public interface ArticleDao extends JpaRepository<Article, Long> {

    @Transactional
    @Modifying
    @Query("update Article set isDelete = 1 where articleId = ?1")
    boolean remove(Long articleId);

    List<Article> findArticlesBySubjectIdAndIsDelete(Long subjectId, boolean isDelete);
}
