package cn.iflyapi.blog.util;

import cn.iflyapi.blog.exception.FlyapiException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * author: flyhero
 * date: 2018-12-15 10:49 AM
 */
public class FastValidator {

    public static FastValidator doit() {
        return new FastValidator();
    }

    public FastValidator notEmpty(Object o, String paramName) {
        if (null == o) {
            throw new FlyapiException("参数[" + paramName + "]不能为空");
        }
        if (o instanceof String) {
            String s = (String) o;
            if (s.length() == 0) {
                throw new FlyapiException("参数[" + paramName + "]不能为空");
            }
        }
        return this;
    }

    public FastValidator notEmpty(String... params) {
        for (String s : params) {
            if (null == s || s.length() == 0) {
                throw new FlyapiException("参数不能为空");
            }
        }
        return this;
    }


    public FastValidator onMax(Object o, int max, String paramName) {
        if (null == o) {
            throw new FlyapiException("参数[" + paramName + "]不能为空");
        }
        if (o instanceof Integer) {
            int num = (Integer) o;
            if (num > max) {
                throw new FlyapiException("参数[" + paramName + "]最大不能超过[" + max + "]");
            }
        } else if (o instanceof String) {
            String s = (String) o;
            if (s.length() > max) {
                throw new FlyapiException("参数[" + paramName + "]最大不能超过[" + max + "]");
            }
        }
        return this;
    }

    public FastValidator onMin(Object o, int min, String paramName) {
        if (null == o) {
            throw new FlyapiException("参数[" + paramName + "]不能为空");
        }
        if (o instanceof Integer) {
            int num = (Integer) o;
            if (num < min) {
                throw new FlyapiException("参数[" + paramName + "]最小不能少于[" + min + "]");
            }
        } else if (o instanceof String) {
            String s = (String) o;
            if (s.length() < min) {
                throw new FlyapiException("参数[" + paramName + "]最小不能少于[" + min + "]");
            }
        }
        return this;
    }


    public static void main(String[] args) {
        int a = 10;
        FastValidator.doit().onMax(a, 9, "ceshi");
    }
}
