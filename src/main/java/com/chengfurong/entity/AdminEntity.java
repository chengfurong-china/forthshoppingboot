package com.chengfurong.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("bid_admin")
public class AdminEntity {
    private Integer adminId;
    private String adminName;
    private String adminPsw;
    private Integer stateId;
    private String adminDesc;
}
