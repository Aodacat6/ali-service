package com.mycom.provider.intercept;

import com.mycom.provider.util.CurrentUser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ：songdalin
 * @date ：2022-4-21 上午 09:19
 * @description：
 * @modified By：
 * @version: 1.0
 */
@Component
public class MyIntercept implements HandlerInterceptor {

    @Autowired
    private CurrentUser currentUser;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("当前线程：" + Thread.currentThread().getName());
        final String user_id = request.getHeader("USER_ID");
        if (StringUtils.isBlank(user_id)) {
            throw new RuntimeException("当前用户未登录~");
        }
        currentUser.setCurUserId(user_id);
        return true;
    }
}
