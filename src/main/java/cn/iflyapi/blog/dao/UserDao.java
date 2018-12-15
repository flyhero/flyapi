package cn.iflyapi.blog.dao;

import cn.iflyapi.blog.entity.User;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: qfwang
 * @date: 2018-12-13 9:54 AM
 */
@Repository
public interface UserDao extends JpaRepository<User,Long> {

    List<User> findAllByIsDeleteEquals(Boolean isDelete);

    User findByUsernameAndPassword(String username, String password);
}
