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
@ApiModel(value="BidType对象", description="")
public class BidType implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "类型ID")
      @TableId(value = "TYPE_ID", type = IdType.AUTO)
    private Integer typeId;

    @ApiModelProperty(value = "类型名称")
    @TableField("TYPE_NAME")
    private String typeName;

    @ApiModelProperty(value = "类型的父ID,0:没有父亲，为第一级")
    @TableField("PARENT_ID")
    private Integer parentId;


}
