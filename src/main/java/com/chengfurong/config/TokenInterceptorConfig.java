package com.chengfurong.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName TokenInterceptorConfig
 * @Description Token拦截器
 * @Author chengfurong
 * @Date 2021/12/11 15:05
 * @Version 1.0
 **/
@Configuration
public class TokenInterceptorConfig  implements WebMvcConfigurer {
    @Autowired
    TokenAuthorizationInterceptor tokenAuthorizationInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 拦截所有请求，通过判断是否有 @TokenRequire 注解 决定是否需要登录
        registry.addInterceptor(tokenAuthorizationInterceptor)
                .addPathPatterns("/**");
    }
//    @Bean
//    public TokenAuthorizationInterceptor  tokenAuthorizationInterceptor(){
//        return new TokenAuthorizationInterceptor();
//    }
}
