package com.undojoy.myspringboot.mvc;

import com.undojoy.myspringboot.interceptor.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor())
                .addPathPatterns("/**")  // 拦截所有路径
                .excludePathPatterns("/main") // 排除路径
                .order(1);  // 指定拦截器的顺序, 越小越先执行
        // 可以配置多个，未指定order按照书写顺序执行，否则越小越先执行
        registry.addInterceptor(new MyInterceptor())
                .addPathPatterns("/**")  // 拦截所有路径
                .excludePathPatterns("/main") // 排除路径
                .order(2);  // 指定拦截器的顺序, 越小越先执行
    }
}
