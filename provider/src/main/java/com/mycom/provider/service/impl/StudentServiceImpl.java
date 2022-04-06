package com.mycom.provider.service.impl;

import com.mycom.dto.Student;
import com.mycom.serivce.StudentService;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author ：songdalin
 * @date ：2022-04-06 下午 04:08
 * @description：
 * @modified By：
 * @version: 1.0
 */
@DubboService
public class StudentServiceImpl implements StudentService {


    @Override
    public Student findAll() {
        Student s1 = new Student();
        s1.setName("大喵");
        s1.setAge(12);
        return s1;
    }
}
