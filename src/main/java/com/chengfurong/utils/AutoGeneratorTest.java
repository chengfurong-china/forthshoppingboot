package com.chengfurong.utils;


import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;

/**
 * @Author chengfurong
 * @create 2021/9/25 20:30
 */
public class AutoGeneratorTest {
    public static void main(String[] args) {
        // 需要构建一个 代码自动生成器 对象
        AutoGenerator mpg = new AutoGenerator();
        // 配置策略
        // 1、全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");

        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("chengfurong");
        gc.setOpen(false);
        // 是否覆盖
        gc.setFileOverride(false);
        // 去Service的I前缀
        gc.setServiceName("%sService");
//        gc.setIdType(IdType.ID_WORKER);
        gc.setDateType(DateType.ONLY_DATE);
        gc.setSwagger2(true);
        mpg.setGlobalConfig(gc);
        //2、设置数据源
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/bidshopping?useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT%2B8");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root");
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);
        //3、包的配置
        PackageConfig pc = new PackageConfig();
        //模块名
        pc.setModuleName("");
        //包名
        pc.setParent("com.chengfurong");
        //实体类包名
        pc.setEntity("entity");
        //mapper包名
        pc.setMapper("mapper");
        //service包名
        pc.setService("service");
        //控制器包名
        pc.setController("handler");
        mpg.setPackageInfo(pc);
        //4、策略配置
        StrategyConfig strategy = new StrategyConfig();
        // 设置要映射的表名
        strategy.setInclude("bid_goods");
        //实体类名下划线转驼峰命名
        strategy.setNaming(NamingStrategy.underline_to_camel);
        //字段名下划线转驼峰命名
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        // 自动lombok；
        strategy.setEntityLombokModel(true);
        //逻辑删除
        strategy.setLogicDeleteFieldName("deleted");
        // 自动填充配置
        TableFill createTime = new TableFill("create_time", FieldFill.INSERT);
        TableFill modifiedTime = new TableFill("modified_time", FieldFill.INSERT_UPDATE);
        ArrayList<TableFill> tableFills = new ArrayList<>();
        tableFills.add(createTime);
        tableFills.add(modifiedTime);
        strategy.setTableFillList(tableFills);
        // 乐观锁
        strategy.setVersionFieldName("version");
        //设置Restful风格的驼峰命名
        strategy.setRestControllerStyle(true);
        //Controller允许访问的时候参数用下划线传入，比如localhost:8080/hello_id_2
        strategy.setControllerMappingHyphenStyle(true);
        mpg.setStrategy(strategy);
        //执行
        mpg.execute();
    }
}
