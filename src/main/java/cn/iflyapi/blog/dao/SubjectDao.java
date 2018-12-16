package cn.iflyapi.blog.dao;

import cn.iflyapi.blog.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: flyhero
 * @date: 2018-12-16 4:42 PM
 */
@Repository
public interface SubjectDao extends JpaRepository<Subject, Long> {

    @Modifying
    @Query("update Subject set isDelete = 1 where subjectId = ?1")
    boolean remove(Long subjectId);

    List<Subject> findSubjectsByUserIdAndIsDelete(Long userId, boolean isDelete);

    List<Subject> findSubjectsByUserIdAndIsDeleteAndIsPrivate(Long userId, boolean isDelete, boolean isPrivate);

    boolean existsSubjectBySubjectIdAndUserId(Long subjectId, Long userId);
}
