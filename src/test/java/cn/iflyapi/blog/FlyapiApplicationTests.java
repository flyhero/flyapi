package cn.iflyapi.blog;

import cn.iflyapi.blog.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FlyapiApplicationTests {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Test
    public void contextLoads() {
        System.out.println(userDao.existsUserByUsernameAndIsDelete("flyhero", true));
    }

    @Test
    public void testRedis() {
        redisTemplate.opsForValue().set("name", "qfwang", 100, TimeUnit.SECONDS);
        String val = redisTemplate.opsForValue().get("name");
        System.out.println(val);
    }

}
