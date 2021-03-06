package com.xiaojihua.m03;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class M03LoggingApplicationTests {

    // 设置日志记录器，LoggerFactory是SLF4J的API
    Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    void contextLoads() {
        // 日志的记录级别（由低到高）
        // 可以调整日志级别
        logger.trace("这是trace日志...");
        logger.debug("这是debug日志...");
        logger.info("这是infor日志...");
        logger.warn("这是warn日志...");
        logger.error("这是error日志...");
    }

}
