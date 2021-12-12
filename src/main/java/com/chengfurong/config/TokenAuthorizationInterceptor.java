package com.chengfurong.config;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.chengfurong.dto.ResponseResult;
import com.chengfurong.entity.CustomerEntity;
import com.chengfurong.service.CustomerService;
import com.chengfurong.token.TokenPass;
import com.chengfurong.token.TokenRequire;
import com.chengfurong.utils.TokenUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @ClassName TokenAuthorizationInterceptor
 * @Description token权限拦截器
 * @Author chengfurong
 * @Date 2021/12/11 15:11
 * @Version 1.0
 **/
@Component
public class TokenAuthorizationInterceptor implements HandlerInterceptor {

    @Autowired
    private CustomerService customerService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 从 http 请求头中取出 token
        String token =request.getHeader("token");
        System.out.println("token=" + token);
        // 如果不是映射到方法直接通过
        if(!(handler instanceof HandlerMethod)){
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        //检查是否有passtoken注释，有则跳过认证
        if(method.isAnnotationPresent(TokenPass.class)){
            TokenPass tokenPass = method.getAnnotation(TokenPass.class);
            if(tokenPass.required()){
                return true;
            }
        }
        Annotation[] annotations = method.getAnnotations();
        System.out.println(method.getName() + "," + annotations.length  );
        for(Annotation annotation:annotations){
            System.out.println( annotation.toString());
        }
        //检查有没有需要用户权限的注解
        if(method.isAnnotationPresent(TokenRequire.class)){
            TokenRequire tokenRequire = method.getAnnotation(TokenRequire.class);
            if(tokenRequire.required()){
                // 执行认证
                if(token==null){
//                    throw  new RuntimeException("无Token,请重新登录");
                    response.getWriter().print(JSONObject.toJSONString(ResponseResult.failed(-1,"无Token,请重新登录")));
                    return false;
                }
                String userId = TokenUtil.getTokenUserId();
                System.out.println("userId:" + userId);
                CustomerEntity customerEntity = customerService.findCustomerById(userId);
                if(customerEntity==null){
//                    throw new RuntimeException("用户:"+userId+" 不存在,请重新登录");
                    response.getWriter().print(JSONObject.toJSONString(ResponseResult.failed(-1,"用户:"+userId+" 不存在,请重新登录")));
                    return false;
                }
                // 验证 token
                JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(customerEntity.getCsPsw())).build();
                try {
                    jwtVerifier.verify(token);
                }catch (JWTVerificationException e){
//                    throw  new RuntimeException("401");
                    response.getWriter().print(JSONObject.toJSONString(ResponseResult.failed(401,"Token验证失败，请重新登录")));
                    return false;
                }
                return true;
            }
        }
//        Cookie cookie = new Cookie("token",token);
//        cookie.setPath("/");
//        response.addCookie(cookie);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

}
