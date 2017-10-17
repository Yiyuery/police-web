package cn.com.showclear.police.mapper;

import cn.com.showclear.police.dao.police.ShunFengMapperImpl;

/**
 * Mapper 数据交互接口管理
 * @author YF-XIACHAOYANG
 * @date 2017/9/5 9:38
 */
public class MapperManager {

    /**
     * 顺丰快递数据
     */
    private static ShunFengMapper _shufengMapper ;


    /**
     * 私有构造方法，防止被实例化
     */
    private MapperManager(){}

    /**
     * 此处使用一个内部类来维护单例
     */
    private static final class App{
        private static MapperManager INSTANCE = new MapperManager();
    }

    /**
     * 获取实例
     * @return
     */
    public static  MapperManager getInstance() {
        return App.INSTANCE;
    }


    public  ShunFengMapper shufengMapper(){
        if (_shufengMapper == null) {
            _shufengMapper =  new ShunFengMapperImpl();
        }
        return _shufengMapper;
    }

}
