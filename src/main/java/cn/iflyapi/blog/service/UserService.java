package cn.iflyapi.blog.service;

import cn.iflyapi.blog.annotation.OpLog;
import cn.iflyapi.blog.dao.UserMapper;
import cn.iflyapi.blog.dao.custom.UserCustomMapper;
import cn.iflyapi.blog.entity.Store;
import cn.iflyapi.blog.entity.User;
import cn.iflyapi.blog.entity.UserExample;
import cn.iflyapi.blog.enums.CodeMsgEnum;
import cn.iflyapi.blog.enums.OperationEnum;
import cn.iflyapi.blog.enums.PlatFormEnum;
import cn.iflyapi.blog.exception.FlyapiException;
import cn.iflyapi.blog.model.Cookie;
import cn.iflyapi.blog.pojo.dto.Support;
import cn.iflyapi.blog.pojo.dto.UserBaseDto;
import cn.iflyapi.blog.util.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * author: flyhero
 * date: 2018-12-13 11:05 AM
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserCustomMapper userCustomMapper;

    @Autowired
    private SnowflakeIdWorker idWorker;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StoreService storeService;

    public List<User> findAllUser() {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andIsDeleteEqualTo(false);
        return userMapper.selectByExample(userExample);
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
/*        Object key = redisTemplate.opsForValue().get(ip + "-register");
        if (Objects.isNull(key)) {
            redisTemplate.opsForValue().set(ip + "-register", "1", 24, TimeUnit.HOURS);
        } else {
            throw new FlyapiException(CodeMsgEnum.USER_ALREADY_REGISTER);
        }*/

        boolean isEmail = FormatValidUtils.isEmail(username);
        boolean isPhoneNumber = FormatValidUtils.isPhoneNumber(username);
        if (!isEmail && !isPhoneNumber) {
            throw new FlyapiException(CodeMsgEnum.USERNAME_MUST_MAIL_OR_PHONE);
        }
        String encryptPasswd = DigestUtils.md5DigestAsHex(password.getBytes());
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(username).andIsDeleteEqualTo(false);
        boolean isExist = userMapper.countByExample(userExample) > 0;
        if (isExist) {
            throw new FlyapiException(CodeMsgEnum.USERNAME_EXIST);
        }
        User user = new User();
        user.setUserId(idWorker.nextId());
        user.setUsername(username);
        user.setPassword(encryptPasswd);
        user.setCreateTime(new Date());
        user.setNickName(Constant.DEFAULT_NICKNAME[RandomUtils.randomInt(0, Constant.DEFAULT_NICKNAME.length - 1)]);
        if (isEmail) {
            user.setEmail(username);
        } else {
            user.setPhone(username);
        }
        user.setPlatform(PlatFormEnum.isExistCode(platform) ? platform : 0);

        userMapper.insertSelective(user);

        //默认图床设置
        Store store = new Store();
        store.setId(idWorker.nextId());
        store.setUserId(user.getUserId());
        store.setIsTry(true);
        storeService.save(store);

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

    @OpLog(op = OperationEnum.USER_LOGIN, score = 2)
    public Cookie login(String username, String password) {
        //1. 验证参数
        FastValidator.doit().notEmpty(username, "username").notEmpty(password, "passwd");
        //2. 业务判断
        String encryptPasswd = DigestUtils.md5DigestAsHex(password.getBytes());
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(username).andPasswordEqualTo(encryptPasswd);
        List<User> userList = userMapper.selectByExample(userExample);
        if (CollectionUtils.isEmpty(userList)) {
            throw new FlyapiException(CodeMsgEnum.USERNAME_OR_PASSWD_INVALID);
        }
        if (userList.get(0).getIsDisable()) {
            throw new FlyapiException(CodeMsgEnum.USER_IS_DISABLED);
        }
        String token = null;
        try {
            token = JwtUtils.getToken(userList.get(0).getUserId(), userList.get(0).getNickName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Cookie cookie = new Cookie();
        cookie.setUserId(userList.get(0).getUserId().toString());
        cookie.setNickName(userList.get(0).getNickName());
        cookie.setToken(token);
        return cookie;
    }

    public User findOne(Long userId) {
        User user = userMapper.selectByPrimaryKey(userId);
        if (Objects.isNull(user)) {
            throw new FlyapiException(CodeMsgEnum.RESOURCE_NOT_EXIST);
        }
        return user;
    }

    public void viewHomePage(Long userId) {
        userCustomMapper.viewHomePage(userId);
    }

    public void resetPassword(String oldPassword, String newPassword, Long userId) {
        String encryptPasswd = DigestUtils.md5DigestAsHex(oldPassword.getBytes());
        User user = findOne(userId);
        if (!user.getPassword().equals(encryptPasswd)) {
            throw new FlyapiException(CodeMsgEnum.USERNAME_OR_PASSWD_INVALID);
        }
        FastValidator.doit().notEmptyAndOnMin(newPassword, 6, "newPassword");
        String newPwd = DigestUtils.md5DigestAsHex(newPassword.getBytes());
        User saveUser = new User();
        saveUser.setUserId(userId);
        saveUser.setPassword(newPwd);
        userMapper.updateByPrimaryKeySelective(saveUser);
    }

    public void updateSupport(Support support, Long userId) {
        FastValidator.doit().notEmpty(support.getSupportWord(), support.getSupportQrcode());
        User user = new User();
        BeanUtils.copyProperties(support, user);
        user.setUserId(userId);
        userMapper.updateByPrimaryKeySelective(user);
    }


    public void update(UserBaseDto support, Long userId) {
        User user = new User();
        BeanUtils.copyProperties(support, user);
        user.setUserId(userId);
        userMapper.updateByPrimaryKeySelective(user);
    }


}
