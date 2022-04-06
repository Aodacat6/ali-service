package com.mycom.consumer.controller;

import com.mycom.serivce.StudentService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：songdalin
 * @date ：2022-04-06 下午 04:19
 * @description：
 * @modified By：
 * @version: 1.0
 */
@RestController
@RequestMapping("/rest")
public class StudentController {

    @DubboReference
    private StudentService studentService;

    @GetMapping("/")
    public String getStudent() {
        return studentService.findAll().toString();
    }

}
