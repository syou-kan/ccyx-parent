package com.zxwcbj.ccyx;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 权限管理模块启动类
 * @author a8480
 */

@SpringBootApplication
@EnableDiscoveryClient
public class ServiceAclApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceAclApplication.class, args);
    }

}
