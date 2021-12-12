package com.chengfurong;

import com.chengfurong.entity.AdminEntity;
import com.chengfurong.entity.CustomerEntity;
import com.chengfurong.mapper.AdminMapper;
import com.chengfurong.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
//import org.springframework.util.Assert;

import java.util.List;

@SpringBootTest
class ForthshoppingbootApplicationTests {

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private CustomerService customerService;
    @Test
    void contextLoads() {
        List<AdminEntity> list = adminMapper.selectList(null);
        Assert.notNull(list,"ok");
        System.out.println(list);
        list.forEach(System.out::println);
    }
    @Test
    void loginTest(){
        CustomerEntity customerEntity = customerService.login("晓明","123");
        System.out.println(customerEntity);
        Assert.notNull(customerEntity,"null");
    }

}
