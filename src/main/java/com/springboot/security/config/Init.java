package com.springboot.security.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @Description
 * @Author 荼蘼
 * @Date 2020/5/22 23:48
 */
@Slf4j
@Component
public class Init implements ApplicationListener<WebServerInitializedEvent> {
    @Override
    public void onApplicationEvent(WebServerInitializedEvent event) {
        log.info("init=========={}", LocalDateTime.now());
    }
}
