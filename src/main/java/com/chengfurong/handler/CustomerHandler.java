package com.chengfurong.handler;

import com.chengfurong.dto.ResponseResult;
import com.chengfurong.entity.CustomerEntity;
import com.chengfurong.service.CustomerService;
import com.chengfurong.token.TokenPass;
import com.chengfurong.utils.ImageUtil;
import com.chengfurong.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api")
public class CustomerHandler {
    @Autowired
    private CustomerService customerService;
    @RequestMapping("/login")
    @TokenPass
    public ResponseResult login(String acc,String psw,HttpServletResponse response){
        System.out.println(acc + ","+psw);
        CustomerEntity customerEntity = customerService.login(acc,psw);
        if(customerEntity!=null){
            //登录成功，创建token，并把token写入到cookie中
            String token = TokenUtil.createToken(acc,psw);
            Cookie cookie = new Cookie("token",token);
            cookie.setPath("/");
            response.addCookie(cookie);
        }
        return customerEntity==null
                ?ResponseResult.failed("账号或密码错误")
                :ResponseResult.ok(customerEntity);
    }

    @RequestMapping("/getcode")
    public void createCode(HttpServletRequest request, HttpServletResponse response) throws Exception{
        response.setHeader("Pragma","No-cache");
        response.setHeader("Cache-Control","No-cache");
        response.setDateHeader("Expires",0);
        response.setContentType("image/jpeg");
        ImageUtil.writeCheckCode(request,response);

    }
}
