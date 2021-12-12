package com.chengfurong.handler;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chengfurong.dto.ResponseResult;
import com.chengfurong.entity.BidGoods;
import com.chengfurong.service.BidGoodsService;
import com.chengfurong.token.TokenRequire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Wrapper;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author chengfurong
 * @since 2021-12-05
 */
@RestController
@RequestMapping("/api")
public class BidGoodsController {

    @Autowired
    public BidGoodsService bidGoodsService;

    @RequestMapping("/goodsfind")
    @TokenRequire
    public ResponseResult find(@RequestParam(value = "pagecurr",defaultValue = "1")Integer pagecurr,
                               @RequestParam(value = "pagesize",defaultValue = "8")Integer pagesize){
//        bidGoodsService.list
        System.out.println(pagecurr+","+pagesize);
        IPage<BidGoods> page = new Page<>(pagecurr,pagesize);
        Object obj = bidGoodsService.page(page);
        System.out.println(obj);
        return ResponseResult.ok(obj);
    }

    @RequestMapping("/goodsfindback")
    @TokenRequire
    public ResponseResult findGoods(@RequestParam(value = "pagecurr",defaultValue = "1")Integer pagecurr,
                                    @RequestParam(value = "pagesize",defaultValue = "8")Integer pagesize,
                                    @RequestParam(value = "gname",defaultValue = "") String gname,
                                    @RequestParam(value = "typeid",defaultValue = "") String typeId){

        System.out.println(pagecurr+","+pagesize+","+gname+","+typeId);
        QueryWrapper<BidGoods> wrapper = new QueryWrapper<>();
        wrapper.like("gname",gname);
        if(!"".equals(typeId)){
            wrapper.eq("type_id",typeId);
        }
        IPage<BidGoods> page = new Page<>(pagecurr,pagesize);
        Object obj = bidGoodsService.page(page,wrapper);
        System.out.println(obj);
        return ResponseResult.ok(obj);
    }

}

