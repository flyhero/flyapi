package cn.iflyapi.blog.service;

import cn.iflyapi.blog.dao.StoreMapper;
import cn.iflyapi.blog.entity.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author qfwang
 * @date 2018-12-22 7:04 PM
 */
@Service
public class StoreService {

    @Autowired
    private StoreMapper storeMapper;

    public boolean save(Store store) {
        store.setCreateTime(new Date());
        int num = storeMapper.insertSelective(store);
        return num > 0;
    }

    public boolean update(Store store) {
        int num = storeMapper.updateByPrimaryKeySelective(store);
        return num > 0;
    }
}
