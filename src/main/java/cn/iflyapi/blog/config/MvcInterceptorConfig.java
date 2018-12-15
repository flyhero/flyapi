package cn.iflyapi.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * author: flyhero
 * date: 2018-12-14 5:27 PM
 */
@Configuration
public class MvcInterceptorConfig extends WebMvcConfigurationSupport {

    private final static String[] EXCLUDED_PATH_PATTERNS = new String[]{
            "/webjars/**",
            "/swagger-resources/**",
            "/v2/api-docs",
            "/error",
            "/swagger-ui.html/**"
    };

    /**
     * 将Swagger2 的swagger-ui.html加入资源路径下,否则Swagger2静态页面不能访问。要想使资源能够访问，可以有两种方法
     * 一：需要配置类继承WebMvcConfigurationSupport 类，实现addResourceHandlers方法。
     * 但是实现了WebMvcConfigurationSupport以后，Spring Boot的 WebMvc自动配置就会失效，具体表现比如访问不到
     * 静态资源（js，css等）了，这是因为WebMvc的自动配置都在WebMvcAutoConfiguration类中，但是类中有这个注解
     *
     * @param registry
     * @ConditionalOnMissingBean({WebMvcConfigurationSupport.class})，意思是一旦在容器中检测到 WebMvcConfigurationSupport这个类，WebMvcAutoConfiguration类中的配置都不生效。
     * 所以一旦我们自己写的配置类继承了WebMvcConfigurationSupport，相当于容器中已经有了WebMvcConfigurationSupport，
     * 所有默认配置都不会生效，都得自己在配置文件中配置。
     * 二：继承WebMvcConfigurer接口，这里采用此方法 网上有人说使用该方法会导致date编译等问题，可能在配置文件中得到解决，
     * 本人没有碰到，不多做解释
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/templates/**").addResourceLocations("classpath:/templates/");
        /*放行swagger*/
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
        super.addResourceHandlers(registry);
    }

    @Bean
    public JwtInterceptor jwtInterceptor() {
        return new JwtInterceptor();
    }

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        // 注册拦截器
        InterceptorRegistration ir = registry.addInterceptor(new JwtInterceptor());
        // 配置拦截的路径
        ir.addPathPatterns("/**");
        // 配置不拦截的路径
        ir.excludePathPatterns(EXCLUDED_PATH_PATTERNS);
        // 还可以在这里注册其它的拦截器
        registry.addInterceptor(new SQLInjectInterceptor()).addPathPatterns("/**");
    }
}
