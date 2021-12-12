package com.chengfurong.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;
@Data
@TableName("bid_customer")
public class CustomerEntity {
    private Integer customerId;
    private String userName;
    private String nickName;
    private String csPsw;
    private String sex;
    private Date birthday;
    private Integer cityId;
    private String addr;
    private  String phone;
    private Date regTime;
    private  Integer stateId;
    private Integer money;
}
