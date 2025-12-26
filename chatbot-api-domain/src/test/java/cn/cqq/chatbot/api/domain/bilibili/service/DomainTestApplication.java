package cn.cqq.chatbot.api.domain.bilibili.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 仅用于domain层测试的Spring启动类，扫描范围仅限domain模块
@SpringBootApplication(scanBasePackages = "cn.cqq.chatbot.api.domain")
public class DomainTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(DomainTestApplication.class, args);
    }
}