package com.craft.tvshowme;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = {"com.craft.tvshowme.infrastructure.adapters.clients"})
@OpenAPIDefinition(info = @Info(title = "Tv-ShowMe API", version = "1.0"))
public class TvShowmeApplication {

    public static void main(String[] args) {
        SpringApplication.run(TvShowmeApplication.class, args);
    }

}
