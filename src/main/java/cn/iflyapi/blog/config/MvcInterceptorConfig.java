package cn.iflyapi.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author: qfwang
 * @date: 2018-12-14 5:27 PM
 */
@Configuration
public class MvcInterceptorConfig extends WebMvcConfigurationSupport {

        private final static String[] EXCLUDED_PATH_PATTERNS = new String[] {
            "/account/**",
            "/webjars/**",
            "/swagger-resources/**",
            "/v2/api-docs",
            "/error",
            "/health/**",
            "/device/pad/**",
            "/ledSetting/colors",
            "/swagger-ui.html",
            "/upload/**",
            "/api/**"
    };

    @Bean
    public JwtInterceptor jwtInterceptor(){
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
