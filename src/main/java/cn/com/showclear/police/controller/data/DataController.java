package cn.com.showclear.police.controller.data;

import cn.com.showclear.common.DataTypes;
import cn.com.showclear.police.service.AppManagers;
import com.jfinal.core.Controller;

/**
 * 通用数据接口
 * Created by Yiyuery on 2017/10/17.
 */
public class DataController extends Controller{

    /**
     * 数据查询测试模版
     */
    public void queryData(){
        AppManagers.getPoliceManager().queryDispatcher(DataTypes.DATA_TYPE_SHUNFENG.getValue());
        renderJson(0);
    }
}
