package cn.iflyapi.blog.controller;

import cn.iflyapi.blog.util.JwtUtils;
import com.auth0.jwt.interfaces.Claim;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * author: flyhero
 * date: 2018-12-12 7:48 PM
 */
public abstract class BaseController {

    protected HttpServletRequest request;

    protected HttpServletResponse response;


    /**
     * ModelAttribute标注的方法会在Controller类的每个映射url的控制执行方法之前执行
     *
     * @param request
     * @param response
     */
    @ModelAttribute
    public void setReqAndRes(HttpServletRequest request, HttpServletResponse response) {
        this.response = response;
        this.request = request;
    }


    /**
     * 获取当前用户id
     *
     * @return
     */
    protected Long getUserId() {
        Map<String, Claim> map = getStringClaimMap();
        if (CollectionUtils.isEmpty(map)) {
            return null;
        }
        return Long.valueOf(map.get("userId").asString());
    }

    /**
     * 获取当前用户昵称
     *
     * @return
     */
    protected Long getNickName() {
        Map<String, Claim> map = getStringClaimMap();
        if (CollectionUtils.isEmpty(map)) {
            return null;
        }
        return Long.valueOf(map.get("nickName").asString());
    }

    private Map<String, Claim> getStringClaimMap() {
        String token = request.getHeader("Authorization");
        if (StringUtils.isEmpty(token)) {
            return null;
        }
        return JwtUtils.verify(token);
    }
}
