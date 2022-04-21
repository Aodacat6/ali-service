package com.mycom.gateway.controller;

import com.mycom.gateway.util.JWTUtils;
import lombok.Data;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：songdalin
 * @date ：2022-4-20 下午 04:34
 * @description：
 * @modified By：
 * @version: 1.0
 */
@RestController
@RequestMapping
public class LoginController {

    @PostMapping("/login")
    public String login(@RequestBody LoginInfo loginInfo) {
        if (loginInfo!=null && "admin".equals(loginInfo.getUsername()) && "123456".equals(loginInfo.getPassword())) {
            return JWTUtils.createJwt(loginInfo.getUsername());
        }
        return "";
    }
}

@Data
class LoginInfo{
    private String username;
    private String password;
}