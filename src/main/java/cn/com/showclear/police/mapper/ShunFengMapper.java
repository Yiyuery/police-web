package cn.com.showclear.police.mapper;

import com.jfinal.plugin.activerecord.Record;

import java.util.List;

/**
 * Created by Yiyuery on 2017/10/16.
 * 顺风数据操作接口定义
 */
public  interface ShunFengMapper extends Mapper {

    /**
     * 数据查询 [测试]
     * @return
     */
    List<Record> queryData();
}
