package cn.com.showclear.police.service;


import cn.com.showclear.police.impl.PoliceManagerImpl;
import cn.com.showclear.police.service.police.PoliceManager;

/**
 * 接口管理
 * @author YF-XIACHAOYANG
 * @date 2017/9/4 12:58
 */
public final class AppManagers implements IBaseManager{

    /**
     * 人员定位数据同步
     */
    private static PoliceManager  police;

    /**
     * 私有构造方法，防止被实例化
     */
    private AppManagers(){}

    /**
     * 此处使用一个内部类来维护单例
     */
    private static final class App{
        private static AppManagers INSTANCE = new AppManagers();
    }

    /**
     * 获取实例
     * @return
     */
    public static  AppManagers getInstance() {
        return App.INSTANCE;
    }

    /**
     * 启动
     */
    @Override
    public void startup() {
        getPoliceManager().startup();
    }

    /**
     * 关闭
     */
    @Override
    public void shutdown() {
        getPoliceManager().shutdown();
    }

    /**
     * 获取 Mloc
     * @return
     */
    public static PoliceManager getPoliceManager() {
        if (police == null) {
            police = new PoliceManagerImpl();
        }
        return police;
    }
}
