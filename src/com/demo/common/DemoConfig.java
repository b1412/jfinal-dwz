package com.demo.common;

import com.alibaba.druid.filter.stat.StatFilter;
import com.demo.blog.BlogController;
import com.demo.blog.UserController;
import com.demo.org.OrgController;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.core.JFinal;
import com.jfinal.ext.handler.RenderingTimeHandler;
import com.jfinal.ext.plugin.tablebind.AutoTableBindPlugin;
import com.jfinal.ext.plugin.tablebind.TableNameStyle;
import com.jfinal.plugin.activerecord.SqlReporter;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.plugin.druid.DruidStatViewHandler;
import com.jfinal.plugin.ehcache.EhCachePlugin;

/**
 * API引导式配置
 */
public class DemoConfig extends JFinalConfig {

    /**
     * 配置常量
     */
    public void configConstant(Constants me) {
        loadPropertyFile("a_little_config.txt"); // 加载少量必要配置，随后可用getProperty(...)获取值
        me.setDevMode(getPropertyToBoolean("devMode", true));
    }

    /**
     * 配置路由
     */
    public void configRoute(Routes me) {
        me.add("/", CommonController.class);
        me.add("/blog", BlogController.class);
        me.add("/user", UserController.class);
        me.add("/org", OrgController.class);
    }

    /**
     * 配置插件
     */
    public void configPlugin(Plugins me) {
        // 配置C3p0数据库连接池插件
        DruidPlugin dp = new DruidPlugin(getProperty("jdbcUrl"), getProperty("user"), getProperty("password"));
        dp.setFilters("stat");
        dp.addFilter(new StatFilter());
        // WallFilter wall = new WallFilter();
        // wall.setDbType("mysql");
        // dp.addFilter(wall);
        me.add(dp);
        me.add(new EhCachePlugin());
        // 配置ActiveRecord插件
        AutoTableBindPlugin arp = new AutoTableBindPlugin(dp, TableNameStyle.LOWER);
        me.add(arp);
        arp.setShowSql(true);
        SqlReporter.setLogger(true);
    }

    /**
     * 配置全局拦截器
     */
    public void configInterceptor(Interceptors me) {
    }

    /**
     * 配置处理器
     */
    public void configHandler(Handlers me) {
        me.add(new RenderingTimeHandler());
//        me.add(new ParamsFilterHandler());
        me.add(new DruidStatViewHandler("/druid"));
    }

    /**
     * 运行此 main 方法可以启动项目，此main方法可以放置在任意的Class类定义中，不一定要放于此
     */
    public static void main(String[] args) {
        JFinal.start("WebRoot", 9090, "/", 5);
    }
}
