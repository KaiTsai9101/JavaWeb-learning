package chapter1.test.config;

import chapter1.test.interceptor.DemoInterceptor;
import chapter1.test.interceptor.TokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// 注册拦截器
@Configuration  // 配置类，应用启动阶段被 Spring 容器扫描并实例化
public class WebConfig implements WebMvcConfigurer {
            // 👆 这个方法只在启动时执行一次
            // 它的作用是"告诉 Spring MVC 有哪些拦截规则"
            // 执行完后，WebConfig 就"退休"了，之后Spring MVC在运行时会自己查规则表

//    @Autowired
//    private DemoInterceptor demoInterceptor;
//    @Autowired
//    private TokenInterceptor tokenInterceptor;
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(tokenInterceptor)
//                .addPathPatterns("/**")      // 拦截所有请求
//                .excludePathPatterns("/login");         // 不拦截的请求
//    }
}
