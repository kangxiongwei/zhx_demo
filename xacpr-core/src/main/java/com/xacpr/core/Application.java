package com.xacpr.core;

import com.xacpr.core.service.IDeviceService;
import com.xacpr.core.service.impl.DeviceService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * 启动服务的类
 * Create by kangxiongwei on 2018/11/15 下午11:13
 */
@RestController
@SpringBootApplication(scanBasePackages = "com.xacpr.core")
@MapperScan("com.xacpr.core.dao")
public class Application {

    public static void main(String[] args) throws IOException {
        ApplicationContext context = SpringApplication.run(Application.class, args);
        IDeviceService deviceService = context.getBean("deviceService", DeviceService.class);
        deviceService.start(8899);
    }

    @RequestMapping("/hello")
    public String hello() {
        return "hello world";
    }

}
