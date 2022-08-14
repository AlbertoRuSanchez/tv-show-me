package com.craft.tvshowme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = {"com.craft.tvshowme.infrastructure.adapters.clients"})
public class TvShowmeApplication {

    public static void main(String[] args) {
        SpringApplication.run(TvShowmeApplication.class, args);
    }

}
