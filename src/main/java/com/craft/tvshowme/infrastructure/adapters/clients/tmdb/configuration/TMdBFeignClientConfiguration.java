package com.craft.tvshowme.infrastructure.adapters.clients.tmdb.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "feign.client.tmdb")
@Getter
@Setter
public class TMdBFeignClientConfiguration {

    private String apiKey;
    private String url;
    private String language;
    private String urlImages;

}
