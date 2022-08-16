package com.craft.tvshowme.infrastructure.configuration;

import com.craft.tvshowme.domain.ports.in.GenreService;
import com.craft.tvshowme.domain.ports.in.TvShowQueryService;
import com.craft.tvshowme.domain.ports.out.TvShowRepository;
import com.craft.tvshowme.domain.service.GenreServiceImpl;
import com.craft.tvshowme.domain.service.TvShowQueryServiceImpl;
import com.craft.tvshowme.infrastructure.adapters.TvShowRepositoryTMdB;
import com.craft.tvshowme.infrastructure.adapters.clients.tmdb.TMdBFeignClient;
import com.craft.tvshowme.infrastructure.adapters.clients.tmdb.configuration.TMdBFeignClientConfiguration;
import com.craft.tvshowme.infrastructure.adapters.clients.tmdb.converter.TMdBTvShowsPageResponseToTvShowsConverter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public TvShowQueryService getTvShowQueryService(TvShowRepository tvShowRepository) {
        return new TvShowQueryServiceImpl(tvShowRepository);
    }

    @Bean
    public TvShowRepository getTvShowRepository(TMdBFeignClient tMdBClient,
                                                TMdBFeignClientConfiguration tMdBFeignClientConfiguration,
                                                TMdBTvShowsPageResponseToTvShowsConverter converter) {
        return new TvShowRepositoryTMdB(tMdBClient, tMdBFeignClientConfiguration, converter);
    }

    @Bean
    public GenreService getGenreService(){
        return new GenreServiceImpl();
    }

    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }

}
