package com.example.mapstructdemo.vo;

import lombok.Data;

/**
 * @author fuhaixin
 * @date 2022/7/6
 **/
@Data
public class DriverDto {

    /**
     * 驾驶员Id
     */
    private Long driverId;
    /**
     * 驾驶员姓名
     */
    private String fullName;
}
