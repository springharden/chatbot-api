package cn.cqq.chatbot.api.domain.bilibili.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 仅用于domain层测试的Spring启动类，扫描范围仅限domain模块
@SpringBootApplication(scanBasePackages = "cn.cqq.chatbot.api.domain")
public class DomainTestApplication {

    // 配置Jackson（下划线转驼峰）
    @Configuration
    static class JacksonTestConfig {
        @Bean("objectMapper")
        public ObjectMapper objectMapper() {
            ObjectMapper mapper = new ObjectMapper();
            mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
            mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return mapper;
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(DomainTestApplication.class, args);
    }
}