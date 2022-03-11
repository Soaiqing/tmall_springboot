


package com.wzh.tmall;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wzh
 * @date 2022-3-11 10:41:23
 */
@SpringBootApplication
@MapperScan
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}


