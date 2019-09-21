package com.cryptal.ark.arkcreditmanager.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by yangyu-ds on 2018/9/18.
 */
@ConfigurationProperties(prefix = "dubbo")
public class DubboConfiguration {

    private String zookeeperUrl;

    public String getZookeeperUrl() {
        return zookeeperUrl;
    }

    public void setZookeeperUrl(String zookeeperUrl) {
        this.zookeeperUrl = zookeeperUrl;
    }

}
