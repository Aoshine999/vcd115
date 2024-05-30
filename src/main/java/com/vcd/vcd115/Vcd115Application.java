package com.vcd.vcd115;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = {"com.vcd.vcd115.mapper"})
@SpringBootApplication
public class Vcd115Application {

    public static void main(String[] args) {
        SpringApplication.run(Vcd115Application.class, args);
    }

}
