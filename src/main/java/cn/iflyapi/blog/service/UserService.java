package cn.iflyapi.blog.service;

import cn.iflyapi.blog.dao.UserDao;
import cn.iflyapi.blog.entity.User;
import cn.iflyapi.blog.enums.CodeMsgEnum;
import cn.iflyapi.blog.enums.PlatFormEnum;
import cn.iflyapi.blog.exception.FlyapiException;
import cn.iflyapi.blog.model.Cookie;
import cn.iflyapi.blog.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * author: flyhero
 * date: 2018-12-13 11:05 AM
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private SnowflakeIdWorker idWorker;

    @Autowired
    private RedisTemplate redisTemplate;

    public List<User> findAllUser() {
        return userDao.findAllByIsDeleteEquals(false);
    }

    /**
     * @param username
     * @param password
     * @param platform
     * @param ip
     * @return Cookie
     * @date 2018/12/15 5:43 PM
     */
    public Cookie register(String username, String password, Integer platform, String ip) {
        FastValidator.doit().notEmpty(username, "username")
                .notEmpty(password, "passwd")
                .onMax(username, 11, "username")
                .onMin(password, 6, "passwd");

        //相同ip每24h只能注册一次，防止恶意注册或接口调用
        Object key = redisTemplate.opsForValue().get(ip + "-register");
        if (Objects.isNull(key)) {
            redisTemplate.opsForValue().set(ip + "-register", "1", 24, TimeUnit.HOURS);
        } else {
            throw new FlyapiException(CodeMsgEnum.USER_ALREADY_REGISTER);
        }

        boolean isEmail = FormatValidUtils.isEmail(username);
        boolean isPhoneNumber = FormatValidUtils.isPhoneNumber(username);
        if (!isEmail && !isPhoneNumber) {
            throw new FlyapiException(CodeMsgEnum.USERNAME_MUST_MAIL_OR_PHONE);
        }
        String encryptPasswd = DigestUtils.md5DigestAsHex(password.getBytes());
        boolean isExist = userDao.existsUserByUsernameAndIsDelete(username, false);
        if (isExist) {
            throw new FlyapiException(CodeMsgEnum.USERNAME_EXIST);
        }
        User user = new User();
        user.setUserId(idWorker.nextId());
        user.setUsername(username);
        user.setPassword(encryptPasswd);
        user.setNickName(Constant.DEFAULT_NICKNAME[RandomUtils.randomInt(0, Constant.DEFAULT_NICKNAME.length - 1)]);
        if (isEmail) {
            user.setEmail(username);
        } else {
            user.setPhone(username);
        }
        user.setPlatform(PlatFormEnum.isExistCode(platform) ? platform : 0);


        User saveUser = userDao.save(user);
        String token = null;
        try {
            token = JwtUtils.getToken(saveUser.getUserId(), saveUser.getNickName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        Cookie cookie = new Cookie();
        cookie.setUserId(saveUser.getUserId().toString());
        cookie.setNickName(saveUser.getNickName());
        cookie.setToken(token);
        return cookie;
    }

    public Cookie login(String username, String password) {
        //1. 验证参数
        FastValidator.doit().notEmpty(username, "username").notEmpty(password, "passwd");
        //2. 业务判断
        User user = userDao.findByUsernameAndPassword(username, password);
        if (Objects.isNull(user)) {
            throw new FlyapiException(CodeMsgEnum.USERNAME_OR_PASSWD_INVALID);
        }
        if (user.getIsDisable()) {
            throw new FlyapiException(CodeMsgEnum.USER_IS_DISABLED);
        }
        String token = null;
        try {
            token = JwtUtils.getToken(user.getUserId(), user.getNickName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Cookie cookie = new Cookie();
        cookie.setUserId(user.getUserId().toString());
        cookie.setNickName(user.getNickName());
        cookie.setToken(token);
        return cookie;
    }

    public User findOne(Long userId) {
        return userDao.getOne(userId);
    }


}
