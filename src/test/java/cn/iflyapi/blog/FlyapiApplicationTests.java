package cn.iflyapi.blog;

import cn.iflyapi.blog.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FlyapiApplicationTests {

    @Autowired
    private UserDao userDao;

    @Test
    public void contextLoads() {
        System.out.println(userDao.existsUserByUsernameAndIsDelete("flyhero", true));
    }

}
