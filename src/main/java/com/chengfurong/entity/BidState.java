package com.chengfurong.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author chengfurong
 * @since 2021-12-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="BidState对象", description="")
public class BidState implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "状态ID")
      @TableId(value = "STATE_ID", type = IdType.AUTO)
    private Integer stateId;

    @ApiModelProperty(value = "状态名称")
    @TableField("STATE_NAME")
    private String stateName;

    @ApiModelProperty(value = "状态类型")
    @TableField("STATE_TYPE")
    private String stateType;

    @ApiModelProperty(value = "状态备注")
    @TableField("STATE_DESC")
    private String stateDesc;


}
