package cn.iflyapi.blog.dao;

import cn.iflyapi.blog.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: qfwang
 * @date: 2018-12-16 4:42 PM
 */
@Repository
public interface SubjectDao extends JpaRepository<Subject, Long> {

    @Modifying
    @Query("update Subject set is_delete = 0 where subject_id = ?1")
    boolean remove(Long subjectId);

    List<Subject> findSubjectsByUserIdAndIsDelete(Long userId, boolean isDelete);
}
