package cn.iflyapi.blog.service;

import cn.iflyapi.blog.dao.CarouselMapper;
import cn.iflyapi.blog.entity.Carousel;
import cn.iflyapi.blog.entity.CarouselExample;
import cn.iflyapi.blog.util.FastValidator;
import cn.iflyapi.blog.util.SnowflakeIdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author flyhero
 * @date 2018-12-31 11:14 AM
 */
@Service
public class CarouselService {

    @Autowired
    private CarouselMapper carouselMapper;

    @Autowired
    private SnowflakeIdWorker idWorker;

    public List<Carousel> listCarousel() {
        CarouselExample carouselExample = new CarouselExample();
        carouselExample.createCriteria().andIsDeleteEqualTo(false);
        carouselExample.setOrderByClause("sort desc");
        return carouselMapper.selectByExample(carouselExample);
    }

    public void save(Carousel carousel) {
        FastValidator.doit().notEmpty(carousel.getTitle(), "title");
        carousel.setId(idWorker.nextId());
        carouselMapper.insertSelective(carousel);
    }

    public void update(Carousel carousel) {
        carouselMapper.updateByPrimaryKeySelective(carousel);
    }

    public void remove(Long carouselId) {
        Carousel carousel = new Carousel();
        carousel.setId(carouselId);
        carousel.setIsDelete(true);
        carouselMapper.updateByPrimaryKeySelective(carousel);
    }


}
