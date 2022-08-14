package com.craft.tvshowme.infrastructure.converter;

import com.craft.tvshowme.domain.model.TvShow;
import com.craft.tvshowme.infrastructure.adapters.clients.tmdb.converter.TMdBTvShowResponseToTvShowConverter;
import com.craft.tvshowme.infrastructure.adapters.clients.tmdb.dto.TMdBTvShowResponse;
import com.craft.tvshowme.utils.TestingUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TMdBTvShowResponseToTvShowConverterShould extends TestingUtils {

    private TMdBTvShowResponseToTvShowConverter underTest;

    @BeforeEach
    void setUp() {
        underTest = new TMdBTvShowResponseToTvShowConverter();
    }

    @Test
    void convert_TMdBTvShowResponse_to_TvShow() {
        //Given
        TMdBTvShowResponse tMdBTvShowResponse = mockTMDdBTvShowsPageResponse().getResults().get(0);

        //When
        TvShow tvShow = underTest.convert(tMdBTvShowResponse);

        //Then
        assertThat(tvShow).isNotNull();
        assertThat(tvShow.getId()).isEqualTo(tMdBTvShowResponse.getId());
        assertThat(tvShow.getName()).isEqualTo(tMdBTvShowResponse.getName());
        assertThat(tvShow.getVoteAverage()).isEqualTo(tMdBTvShowResponse.getVoteAverage());

    }
}
