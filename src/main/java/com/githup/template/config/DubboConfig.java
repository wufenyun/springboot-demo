package com.githup.template.config;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.ProviderConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.AnnotationBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 */
@Configuration
public class DubboConfig {

    @Value("${dubbo.registry.address}")
    private String registryAddress;

    @Value("${dubbo.protocol.port}")
    private Integer dubboProtocolPort;

    @Value("${dubbo.config.threads:200}")
    private Integer dubboThreads;

    /**
     * 应用配置
     *
     * @return
     */
    @Bean
    public ApplicationConfig applicationConfig() {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("template-project");
        applicationConfig.setOwner("wfy");
        return applicationConfig;
    }

    @Bean
    public RegistryConfig registryConfig() {
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress(registryAddress);
        return registryConfig;
    }

    @Bean
    public ProtocolConfig protocolConfig() {
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("dubbo");
        protocolConfig.setPort(dubboProtocolPort);
        protocolConfig.setThreads(dubboThreads);
        return protocolConfig;
    }

    /**
     * 提供者配置
     *
     * @return
     */
    @Bean
    public ProviderConfig providerConfig() {
        ProviderConfig providerConfig = new ProviderConfig();
        providerConfig.setTimeout(10000);
        providerConfig.setDelay(30000);
        providerConfig.setRetries(5);
        providerConfig.setThreads(dubboThreads);
        return providerConfig;
    }

    @Bean
    public static AnnotationBean annotationBean() {
        AnnotationBean annotationBean = new AnnotationBean();
        annotationBean.setPackage("com.github.template.module");
        return annotationBean;
    }
}
