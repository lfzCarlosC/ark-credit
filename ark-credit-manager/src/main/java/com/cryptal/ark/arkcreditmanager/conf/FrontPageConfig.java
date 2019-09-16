package com.cryptal.ark.arkcreditmanager.conf;

import cn.com.gome.page.core.PageManager;
import cn.com.gome.page.core.PageSettings;
import cn.com.gome.page.plugins.style.hui.HuiStylePlugin;
import cn.com.gome.page.plugins.upload.FileUploadPlugin;
import cn.com.gome.page.setting.AdminItems;
import cn.com.gome.page.setting.AdminItemsBuilder;
import cn.com.gome.page.setting.LeafItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FrontPageConfig {

    @Autowired
    private ApplicationContext applicationContext;

    @Qualifier("commonFileUploadPlugin")
    @Autowired
    private FileUploadPlugin fileUploadPlugin; //GFS上传插件

    @Bean
    public PageManager pageManager(){

        AdminItems adminItems = new AdminItemsBuilder()
                .addRootItem("菜单1","isvAccount",
                        new LeafItem("子菜单一", "/admin/isvAccount/page")
                )
                .addRootItem("菜单2","monitor",
                        new LeafItem("子菜单二", "/admin/app/page"),
                        new LeafItem("子菜单三", "/admin/app_level/page"),
                        new LeafItem("子菜单四", "/admin/api_rate_limit/page")
                )
                .build();

        PageSettings pageSettings = new PageSettings();
        pageSettings.setStylePlugin(new HuiStylePlugin()); //使用的页面风格
        pageSettings.setAdminItems(adminItems);
        pageSettings.setTitle("三级分销商城"); //后台标题
        pageSettings.setFileUploadPlugin(fileUploadPlugin); //使用的上传插件 默认不支持上传
        pageSettings.setLoginUserPlugin(new SecurityLoginUserPlugin()); //用户会话管理插件
        return new PageManager(applicationContext,pageSettings);

    }

}
