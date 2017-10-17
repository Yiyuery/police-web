package cn.com.showclear.police.config.routes;

import cn.com.showclear.police.controller.view.ViewController;
import com.jfinal.config.Routes;

/**
 * 界面相关，路径指向："/view/..."
 * @author YF-XIACHAOYANG
 * @date 2017/9/4 12:50
 */
public class ViewRoutes extends Routes {

    public static final String BASE_URI = "/view/";

    @Override
    public void config() {
        //add(uri("index"), ViewController.class);
    }

    private static String uri(String subPath) {
        return BASE_URI + subPath;
    }
}
