package com.mycom.provider.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 * @author ：songdalin
 * @date ：2022-4-21 上午 09:22
 * @description：
 * @modified By：
 * @version: 1.0
 */
@Component
public class CurrentUser {

    //注入userservice，获取用户信息

    private ThreadLocal<String> curUserId = new ThreadLocal<>();

//    /**
//     * todo
//     * 根据当前curuserid，调用userservice，获取用户信息
//     * @return
//     */
//    public UserDto getCurUser() {
//
//    }
//



    public String getUserId() {
        final String userId = curUserId.get();
        if (StringUtils.isBlank(userId)) {
            return "";
        }
        return userId;
    }

    public void setCurUserId(String userId) {
        curUserId.set(userId);
    }








}



