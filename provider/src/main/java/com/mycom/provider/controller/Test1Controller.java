package com.mycom.provider.controller;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：songdalin
 * @date ：2022-4-20 上午 10:26
 * @description：
 * @modified By：
 * @version: 1.0
 */
@RestController
@RequestMapping("/provider1")
public class Test1Controller implements EnvironmentAware {

    private String type;


    @GetMapping("/test")
    public String test() {
        return "hello, this is provier1，" + type;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.type = environment.getProperty("type");
    }
}
