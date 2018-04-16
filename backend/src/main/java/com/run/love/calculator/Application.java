package com.run.love.calculator;

import java.util.concurrent.TimeUnit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.run.love.calculator.model.Couple;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public Cache<String, Couple> coupleRepository() {
        Cache<String, Couple> coupleRepository = CacheBuilder.newBuilder()
                .expireAfterWrite(7, TimeUnit.DAYS)
                .maximumSize(1000)
                .build();
        return coupleRepository;
    }

}
