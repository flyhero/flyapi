package cn.iflyapi.blog.service;

import cn.iflyapi.blog.dao.StoreMapper;
import cn.iflyapi.blog.entity.Store;
import cn.iflyapi.blog.entity.StoreExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * @author flyhero
 * @date 2018-12-22 7:04 PM
 */
@Service
public class StoreService {

    @Autowired
    private StoreMapper storeMapper;

    public Store get(Long userId) {
        StoreExample storeExample = new StoreExample();
        storeExample.createCriteria().andUserIdEqualTo(userId).andIsDeleteEqualTo(false);
        List<Store> storeList = storeMapper.selectByExample(storeExample);
        if (CollectionUtils.isEmpty(storeList)) {
            return null;
        }
        return storeList.get(0);
    }

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
