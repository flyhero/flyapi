package cn.iflyapi.blog.config;

import cn.iflyapi.blog.util.SnowflakeIdWorker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * author: flyhero
 * date: 2018-12-15 3:46 PM
 */
@Configuration
public class IdConfig {

    @Bean
    public SnowflakeIdWorker idWorker() {
        return new SnowflakeIdWorker(0, 0);
    }
}
