package io.honeymon.springboot.multimodule.api.service;

import io.honeymon.springboot.multimodule.api.config.ClientProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @author jiheon.kim on 2018. 7. 5.
 */
@Slf4j
@Service
public class RootService {
    @Resource
    private ClientProperty clientProperty;
    @Value("${spring.datasource.url}")
    private String databaseUrl;

    @PostConstruct
    public void setUp() {
        log.info("Client property: [ID: {}, KEY: {}]", clientProperty.getId(), clientProperty.getKey());
        log.info("Database URL: {}", databaseUrl);
    }
}
