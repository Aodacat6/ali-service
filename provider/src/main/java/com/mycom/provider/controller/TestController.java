package com.mycom.provider.controller;

import com.mycom.provider.util.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ：songdalin
 * @date ：2022-4-20 上午 10:26
 * @description：
 * @modified By：
 * @version: 1.0
 */
@RestController
@RequestMapping("/provider")
public class TestController implements EnvironmentAware {

    private String type;

    @Autowired
    private CurrentUser currentUser;

    @GetMapping("/test")
    public String test() {
        System.out.println("业务中获取当前登录用户：" + currentUser.getUserId());
        return "hello, this is provier，" + type;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.type = environment.getProperty("type");
    }
}
