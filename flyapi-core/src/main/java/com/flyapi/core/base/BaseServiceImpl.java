package com.flyapi.core.base;

import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * author: flyhero
 * Date: 2017/5/13 0013 下午 2:44
 */
public class BaseServiceImpl<Model,Dao> implements BaseService<Model> {

    @Autowired
    public Dao dao;
    @Override
    public int deleteByPrimaryKey(Long id) {
        try {
            Method method = dao.getClass().getDeclaredMethod("deleteByPrimaryKey",id.getClass());
            Object result = method.invoke(dao,id);
            return Integer.parseInt(String.valueOf(result));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int insert(Model record) {
        try {
            Method method=dao.getClass().getDeclaredMethod("insert",record.getClass());
            Object result=method.invoke(dao,record);
            return Integer.parseInt(String.valueOf(result));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int insertSelective(Model record) {
        try {
            Class cl=record.getClass();
            System.out.println("反射类："+dao.getClass().toString());
            Method method=dao.getClass().getDeclaredMethod("insertSelective",record.getClass());
            Object result=method.invoke(dao,record);
            return Integer.parseInt(String.valueOf(result));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Model selectByPrimaryKey(Long id) {
        try {
            Method method=dao.getClass().getDeclaredMethod("selectByPrimaryKey",id.getClass());
            Object result=method.invoke(dao,id);
            return (Model)result;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Model record) {
        try {
            Method method=dao.getClass().getDeclaredMethod("updateByPrimaryKeySelective",record.getClass());
            Object result=method.invoke(dao,record);
            return Integer.parseInt(String.valueOf(result));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return 0;
    }


    @Override
    public int updateByPrimaryKey(Model record) {
        try {
            Method method=dao.getClass().getDeclaredMethod("updateByPrimaryKey",record.getClass());
            Object result=method.invoke(dao,record);
            return Integer.parseInt(String.valueOf(result));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
