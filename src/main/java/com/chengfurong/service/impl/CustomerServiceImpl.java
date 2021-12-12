package com.chengfurong.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chengfurong.entity.CustomerEntity;
import com.chengfurong.mapper.CustomerMapper;
import com.chengfurong.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    /**
     *@Description //TODO
     *@Author chengfurong
     *@Date 2021/12/11 11:18
     *@Param [acc, psw]
     *@return com.chengfurong.entity.CustomerEntity
     **/
    @Override
    public CustomerEntity login(String acc, String psw) {
//        Map<String,Object>  queryMap = new HashMap<>();
//        queryMap.put("user_name",acc);
//        queryMap.put("cs_psw",psw);
//        List<CustomerEntity> list = customerMapper.selectByMap(queryMap);
//        return list.size()>0?list.get(0):null;

        QueryWrapper<CustomerEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name",acc)
                .eq("cs_psw",psw);
        return customerMapper.selectOne(wrapper);

    }

    @Override
    public CustomerEntity findCustomerById(String acc) {
        QueryWrapper<CustomerEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name",acc);
        return customerMapper.selectOne(wrapper);
    }
}
