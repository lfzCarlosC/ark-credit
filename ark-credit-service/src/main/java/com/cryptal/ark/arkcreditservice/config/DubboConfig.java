package com.cryptal.ark.arkcreditservice.config;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.AnnotationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by yangyu-ds on 2018/9/19.
 */
@Configuration
public class DubboConfig {

    @Bean
    public DubboConfiguration dubboConfiguration(){
        return new DubboConfiguration();
    }

    @Bean
    public ApplicationConfig applicationConfig(){
        ApplicationConfig application = new ApplicationConfig();
        application.setName("ark-credit-service");
        application.setLogger("slf4j");
        return application;
    }

    @Bean
    public RegistryConfig registryConfig(){
        RegistryConfig registry = new RegistryConfig();
        registry.setProtocol("zookeeper");
        registry.setAddress(dubboConfiguration().getZookeeperUrl());
        return registry;
    }


    @Bean
    public AnnotationBean dubboAnnotationBean() {
        AnnotationBean annotationBean = new AnnotationBean();
        annotationBean.setPackage("com.cryptal.ark.arkcreditservice");
        return annotationBean;
    }

}
