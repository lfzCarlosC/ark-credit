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
                .addRootItem("栏目管理","column",
                        new LeafItem("栏目管理", "/admin/column/page"),
                        new LeafItem("文章管理", "/admin/document/page")
                )
                .addRootItem("产品管理","goods",
                        new LeafItem("产品分类管理", "/admin/product_category/page"),
                        new LeafItem("销售属性管理", "/admin/sell_category/page"),
                        new LeafItem("商品管理", "/admin/goods/page"),
                        new LeafItem("留言管理", "/admin/comment/page")
                )
                .addRootItem("订单管理","order",
                        new LeafItem("订单管理", "/admin/order/page")
                )
                .addRootItem("会员管理","member",
                        new LeafItem("等级管理", "/admin/rank/page"),
                        new LeafItem("会员管理", "/admin/member/page")
                )
                .addRootItem("财务管理","finance",
                        new LeafItem("充值管理", "/admin/recharge/page"),
                        new LeafItem("提现管理", "/admin/withdraw/page"),
                        new LeafItem("佣金管理", "/admin/commission/page"),
                        new LeafItem("收入管理", "/admin/income/page")
                )
                .addRootItem("系统设置","config",
                        new LeafItem("系统设置", "/admin/config/page")
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
