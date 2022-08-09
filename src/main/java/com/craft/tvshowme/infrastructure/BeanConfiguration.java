package com.craft.tvshowme.infrastructure;

import com.craft.tvshowme.domain.ports.TvShowQueryService;
import com.craft.tvshowme.domain.service.TvShowQueryServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public TvShowQueryService getTvShowQueryService(){
        return new TvShowQueryServiceImpl();
    }

    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }

}
