package com.chengfurong.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
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
@ApiModel(value="BidGoods对象", description="")
public class BidGoods implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商品ID")
      @TableId(value = "GID", type = IdType.AUTO)
    private Integer gid;

    @ApiModelProperty(value = "商品图片")
    @TableField("GPNG")
    private String gpng;

    @ApiModelProperty(value = "商品名称")
    @TableField("GNAME")
    private String gname;

    @ApiModelProperty(value = "商品标题")
    @TableField("GTITLE")
    private String gtitle;

    @ApiModelProperty(value = "商品标题2")
    @TableField("GTITLE2")
    private String gtitle2;

    @ApiModelProperty(value = "商品二级类型")
    @TableField("TYPE_ID")
    private Integer typeId;

    @ApiModelProperty(value = "商品价格")
    @TableField("PRICE")
    private Integer price;

    @ApiModelProperty(value = "商品起拍价格")
    @TableField("OPRICE")
    private Integer oprice;

    @ApiModelProperty(value = "商品数量")
    @TableField("GNUM")
    private Integer gnum;

    @ApiModelProperty(value = "商品起拍时间")
    @TableField("BUYTIME")
    private Date buytime;

    @ApiModelProperty(value = "状态ID")
    @TableField("STATE_ID")
    private Integer stateId;

    @ApiModelProperty(value = "商品入库时间")
    @TableField("GTIME")
    private Date gtime;

    @ApiModelProperty(value = "商品备注")
    @TableField("GOODS_DESC")
    private String goodsDesc;

    @ApiModelProperty(value = "商品结束拍卖时间")
    @TableField("ENDTIME")
    private Date endtime;


}
