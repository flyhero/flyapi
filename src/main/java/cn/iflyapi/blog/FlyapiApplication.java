package cn.iflyapi.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("cn.iflyapi.blog.dao")
@SpringBootApplication
public class FlyapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlyapiApplication.class, args);
    }
}
