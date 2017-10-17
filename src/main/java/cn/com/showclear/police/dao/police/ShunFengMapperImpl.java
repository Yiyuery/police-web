package cn.com.showclear.police.dao.police;

import cn.com.showclear.common.AppConstants;
import cn.com.showclear.police.mapper.ShunFengMapper;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

import java.util.List;

/**
 * Created by Yiyuery on 2017/10/16.
 * 顺丰数据操作
 */
public class ShunFengMapperImpl implements ShunFengMapper{

    @Override
    public boolean update(String tName, String primKey, Record record) {
        return false;
    }

    /**
     * 查询模版 [测试]
     * @return
     */
    @Override
    public List<Record> queryData() {
        String sql = Db.use(AppConstants.DB_KEY_POLICE).getSql("queryData");
        return Db.use(AppConstants.DB_KEY_POLICE).find(sql);

    }
}
