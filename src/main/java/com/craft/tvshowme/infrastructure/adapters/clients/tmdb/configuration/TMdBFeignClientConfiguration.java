package com.craft.tvshowme.infrastructure.adapters.clients.tmdb.configuration;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class TMdBFeignClientConfiguration {

    @Value("${feign.client.tmdb.apiKey}")
    private String apiKey;

    @Value("${feign.client.tmdb.url}")
    private String url;

    @Value("${feign.client.tmdb.language}")
    private String language;

}
