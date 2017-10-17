package cn.com.showclear.police.config;

import cn.com.showclear.police.config.plugins.DbPluginsConfig;
import cn.com.showclear.police.config.routes.DataRoutes;
import cn.com.showclear.police.config.routes.ViewRoutes;
import cn.com.showclear.police.controller.view.ViewController;
import cn.com.showclear.police.service.AppManagers;
import com.jfinal.config.*;
import com.jfinal.ext.handler.ContextPathHandler;
import com.jfinal.render.FreeMarkerRender;
import com.jfinal.render.ViewType;
import com.jfinal.template.Engine;
import org.apache.log4j.Logger;

/**
 * Jfinal 核心配置
 * @author YF-XIACHAOYANG
 * @date 2017/9/4 11:58
 */
public class PoliceConfig extends JFPropConfig {

    private static final Logger log = Logger.getLogger(PoliceConfig.class);

    /**
     * 配置常量
     */
    @Override
    public void configConstant(Constants me) {
        initConfig("app.properties");
        me.setViewType(ViewType.FREE_MARKER);
        me.setDevMode(prop.getBoolean("devMode", false));
    }

    /**
     * 配置路由
     */
    @Override
    public void configRoute(Routes me) {

        me.add("/",ViewController.class);
        // 界面相关 URI 映射
        me.add(new ViewRoutes());
        // 数据相关 URI 映射
        me.add(new DataRoutes());
    }

    @Override
    public void configEngine(Engine engine) {

    }

    /**
     * 配置插件
     * 数据库连接
     */
    @Override
    public void configPlugin(Plugins me) {
        DbPluginsConfig.initialize(me);
    }

    /**
     * 配置全局拦截器
     */
    @Override
    public void configInterceptor(Interceptors interceptors) {

    }

    /**
     * 配置处理器
     */
    @Override
    public void configHandler(Handlers me) {
        me.add(new ContextPathHandler("contextPath"));
    }

    @Override
    public void afterJFinalStart() {
        AppManagers.getInstance().startup();
    }

    @Override
    public void beforeJFinalStop() {
        AppManagers.getInstance().shutdown();
    }


    private void configFreeMarker(Constants me) {
        if (me.getDevMode()) {
            //模板更更新时间,0表示每次都重新加载
            FreeMarkerRender.setProperty("template_update_delay", "0");
        }
        FreeMarkerRender.setProperty("classic_compatible", "true");//如果为null则转为空值,不需要再用!处理
        FreeMarkerRender.setProperty("whitespace_stripping", "true");//去除首尾多余空格
        FreeMarkerRender.setProperty("date_format", "yyyy-MM-dd");
        FreeMarkerRender.setProperty("time_format", "HH:mm:ss");
        FreeMarkerRender.setProperty("datetime_format", "yyyy-MM-dd HH:mm:ss");
        FreeMarkerRender.setProperty("default_encoding", "UTF-8");
    }

}
