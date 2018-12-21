package cn.iflyapi.blog.annotation;

import cn.iflyapi.blog.config.JwtInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author flyhero
 * @date 2018-12-20 12:55 PM
 */
@Component
public class OpenApiScan implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    private JwtInterceptor jwtInterceptor;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        if (event.getApplicationContext().getParent() == null) {
            Map<String, Object> beans = event.getApplicationContext().getBeansWithAnnotation(RestController.class);
            Set<Map.Entry<String, Object>> entries = beans.entrySet();
            Iterator<Map.Entry<String, Object>> iterator = entries.iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, Object> map = iterator.next();
                Class<?> aClass = map.getValue().getClass();
                Method[] methods = aClass.getMethods();
                for (Method method : methods) {
                    if (!method.isAnnotationPresent(OpenApi.class)) {
                        continue;
                    }
                    String hm = "";
                    if (method.isAnnotationPresent(GetMapping.class)) {
                        hm = HttpMethod.GET.name();
                    } else if (method.isAnnotationPresent(PostMapping.class)) {
                        hm = HttpMethod.POST.name();
                    } else if (method.isAnnotationPresent(PatchMapping.class)) {
                        hm = HttpMethod.PATCH.name();
                    } else if (method.isAnnotationPresent(PutMapping.class)) {
                        hm = HttpMethod.PUT.name();
                    } else if (method.isAnnotationPresent(DeleteMapping.class)) {
                        hm = HttpMethod.DELETE.name();
                    } else {
                        continue;
                    }
                    OpenApi openApi = method.getAnnotation(OpenApi.class);
                    jwtInterceptor.register(hm + openApi.value());

                }
            }
        }
    }
}
