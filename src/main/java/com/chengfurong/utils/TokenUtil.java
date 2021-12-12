package com.chengfurong.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @ClassName TokenUtil
 * @Description Token生成工具
 * @Author chengfurong
 * @Date 2021/12/11 10:32
 * @Version 1.0
 **/
public class TokenUtil {
    /**
     *@Author chengfurong
     *@Description 获取Token的用户ID
     *@Date 2021/12/11 11:16
     *@Param []
     *@return java.lang.String
     **/
    public static String getTokenUserId(){
        String token = getRequest().getHeader("token");
        System.out.println("token:"+ token);
        String userId = JWT.decode(token).getAudience().get(0);
        return userId;
    }

    /**
     *@Author chengfurong
     *@Description //TODO
     *@Date 2021/12/11 11:15
     *@Param []
     *@return javax.servlet.http.HttpServletRequest
     **/
    public static HttpServletRequest getRequest(){
        ServletRequestAttributes requestAttributes =(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return requestAttributes==null?null:requestAttributes.getRequest();
    }

    /***
     *@Description 根据userId和password生成token
     *@Author chengfurong
     *@Date 2021/12/11 15:47
     *@Param [userId, password]
     *@return java.lang.String token
     **/
    public static String createToken(String userId,String password){
        Date start = new Date();
        long currentTime = System.currentTimeMillis() + 60 * 1000 * 10; //10分钟有效
        Date end = new Date(currentTime);
        String token = JWT.create()
                          .withAudience(userId)
                          .withIssuedAt(start)
                          .withExpiresAt(end)
                          .sign(Algorithm.HMAC256(password));
        return token;
    }

    
}





