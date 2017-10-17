package cn.com.showclear.police.impl;

import cn.com.showclear.police.mapper.MapperManager;
import cn.com.showclear.police.service.police.PoliceManager;
import com.jfinal.plugin.activerecord.Record;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by Yiyuery on 2017/10/16.
 * 警方数据解析
 */
public class PoliceManagerImpl implements PoliceManager {

    private static final Logger log = Logger.getLogger(PoliceManagerImpl.class);

    @Override
    public void startup() {

    }

    @Override
    public void shutdown() {

    }

    @Override
    public void queryDispatcher(int value) {
       switch(value){
           case 1:
               queryShunFengData();
               break;
           default:break;
       }
    }

    /**
     * 查询顺风快递数据
     */
    private void queryShunFengData() {
        List<Record> list = MapperManager.getInstance().shufengMapper().queryData();
        log.info("测试查询数据："+list.size());
     }
}
