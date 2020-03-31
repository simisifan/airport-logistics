package com.atfcm.airportlogistics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import redis.clients.jedis.Jedis;
import tk.mybatis.spring.annotation.MapperScan;


@tk.mybatis.spring.annotation.MapperScan(basePackages = {"com.atfcm.airportlogistics.mbg.mapper"})
@SpringBootApplication
public class AirportLogisticsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AirportLogisticsApplication.class, args);

    }

}
