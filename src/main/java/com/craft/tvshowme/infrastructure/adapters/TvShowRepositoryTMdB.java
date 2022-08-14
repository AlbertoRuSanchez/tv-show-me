package com.craft.tvshowme.infrastructure.adapters;

import com.craft.tvshowme.domain.model.TvShows;
import com.craft.tvshowme.domain.ports.out.TvShowRepository;
import com.craft.tvshowme.infrastructure.adapters.clients.tmdb.TMdBFeignClient;
import com.craft.tvshowme.infrastructure.adapters.clients.tmdb.configuration.TMdBFeignClientConfiguration;
import com.craft.tvshowme.infrastructure.adapters.clients.tmdb.converter.TMdBTvShowsPageResponseToTvShowsConverter;
import com.craft.tvshowme.infrastructure.adapters.clients.tmdb.dto.TMdBTvShowsPageResponse;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class TvShowRepositoryTMdB implements TvShowRepository {

    private final TMdBFeignClient tMdBFeignClient;
    private final TMdBFeignClientConfiguration tMdBFeignClientConfiguration;
    private final TMdBTvShowsPageResponseToTvShowsConverter converter;

    @Override
    public Optional<TvShows> getTvShows(String page) {

        TMdBTvShowsPageResponse tMdBTvShowsPageResponse = tMdBFeignClient.getTopTvShows(tMdBFeignClientConfiguration.getApiKey(),
                tMdBFeignClientConfiguration.getLanguage(), page);

        return Optional.of(converter.convert(tMdBTvShowsPageResponse));
    }
}
