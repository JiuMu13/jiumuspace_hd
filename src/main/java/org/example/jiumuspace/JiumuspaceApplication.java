package org.example.jiumuspace;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.example.jiumuspace.mapper")
public class JiumuspaceApplication {

    public static void main(String[] args) {
        SpringApplication.run(JiumuspaceApplication.class, args);
    }

}
