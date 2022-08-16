package com.craft.tvshowme.infrastructure.converter;

import com.craft.tvshowme.domain.model.TvShows;
import com.craft.tvshowme.infrastructure.adapters.clients.tmdb.configuration.TMdBFeignClientConfiguration;
import com.craft.tvshowme.infrastructure.adapters.clients.tmdb.converter.TMdBTvShowResponseToTvShowConverter;
import com.craft.tvshowme.infrastructure.adapters.clients.tmdb.converter.TMdBTvShowsPageResponseToTvShowsConverter;
import com.craft.tvshowme.infrastructure.adapters.clients.tmdb.dto.TMdBTvShowsPageResponse;
import com.craft.tvshowme.utils.TestingUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThat;

public class TMdBTvShowsPageResponseToTvShowsConverterShould extends TestingUtils {


    private TMdBTvShowsPageResponseToTvShowsConverter underTest;

    @BeforeEach
    void setUp() {
        underTest = new TMdBTvShowsPageResponseToTvShowsConverter(new TMdBTvShowResponseToTvShowConverter());
    }

    @Test
    void convert_TMdBTvShowsPageResponse_to_TvShows() {
        //Given
        TMdBTvShowsPageResponse tMdBTvShowsPageResponse = mockTMDdBTvShowsPageResponse();

        //When
        TvShows tvShows = underTest.convert(tMdBTvShowsPageResponse);

        //Then
        assertThat(tvShows).isNotNull();
        assertThat(tvShows.getPage()).isEqualTo(tMdBTvShowsPageResponse.getPage());
        assertThat(tvShows.getTotalTvShows()).isEqualTo(tMdBTvShowsPageResponse.getTotalResults());
        assertThat(tvShows.getTotalPages()).isEqualTo(tMdBTvShowsPageResponse.getTotalPages());
        assertThat(tvShows.getTvShows()).hasSameSizeAs(tMdBTvShowsPageResponse.getResults());

    }
}
