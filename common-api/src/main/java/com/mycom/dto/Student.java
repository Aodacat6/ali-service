package com.mycom.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ：songdalin
 * @date ：2022-04-06 下午 03:48
 * @description：
 * @modified By：
 * @version: 1.0
 */
@Data
public class Student implements Serializable {

    private String name;

    private Integer age;
}
