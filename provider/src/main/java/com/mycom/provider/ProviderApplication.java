package com.mycom.provider;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ：songdalin
 * @date ：2022-04-06 下午 03:56
 * @description：
 * @modified By：
 * @version: 1.0
 */
@SpringBootApplication
@EnableDubbo
public class ProviderApplication {

    public static void main(String[] args){
        SpringApplication.run(ProviderApplication.class, args);
    }
}
