package com.cssl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan(basePackages="com.cssl.dao")
@EnableTransactionManagement
@SpringBootApplication
public class SuperiorbuyApplication {
    public static void main(String[] args) throws Exception {

        SpringApplication.run(SuperiorbuyApplication.class,args);

    }
}
