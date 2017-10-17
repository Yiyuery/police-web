package cn.com.showclear.police.config.routes;

import cn.com.showclear.police.controller.data.DataController;
import com.jfinal.config.Routes;

/**
 * 数据相关，路径指向：/data/...
 * @author YF-XIACHAOYANG
 * @date 2017/9/4 12:50
 */
public class DataRoutes extends Routes {

    public static final String BASE_URI = "/data/";

    @Override
    public void config() {
        add(uri("police"), DataController.class);
    }

    private static String uri(String subPath) {
        return BASE_URI + subPath;
    }
}
