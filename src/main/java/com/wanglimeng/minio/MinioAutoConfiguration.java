package com.wanglimeng.minio;

import com.wanglimeng.minio.config.MinioConfig;
import com.wanglimeng.minio.service.MinioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@EnableConfigurationProperties(MinioConfig.class)
public class MinioAutoConfiguration {

    @Autowired
    private MinioConfig minioConfig;

    @Bean
    @ConditionalOnMissingBean(MinioService.class)
    public MinioService MinioService() {
        MinioService minioService = new MinioService(minioConfig);
        return  minioService;
    }
}
