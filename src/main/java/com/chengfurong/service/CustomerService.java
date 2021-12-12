package com.chengfurong.service;

import com.chengfurong.entity.CustomerEntity;

public interface CustomerService {
    CustomerEntity login(String acc ,String psw);
    CustomerEntity findCustomerById(String acc);
}
