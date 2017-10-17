package cn.com.showclear.police.service.police;

import cn.com.showclear.police.service.IBaseManager;

/**
 * Created by Yiyuery on 2017/10/16.
 * 警方数据解析
 */
public interface PoliceManager extends IBaseManager {
    /**
     * 查询路由转发
     * @param value
     */
    void queryDispatcher(int value);
}
