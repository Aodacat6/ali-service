package com.mycom.provider.intercept;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author ：songdalin
 * @date ：2022-4-21 上午 09:42
 * @description：
 * @modified By：
 * @version: 1.0
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private MyIntercept myIntercept;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 添加拦截器
        InterceptorRegistration interceptor = registry.addInterceptor(myIntercept);
        // 设置放行路径
        //interceptor.excludePathPatterns("/hello");
        // 设置拦截的路径
        interceptor.addPathPatterns("/**");
    }
}
