package com.craft.tvshowme.infrastructure;

import com.craft.tvshowme.domain.model.TvShow;
import com.craft.tvshowme.domain.model.TvShows;
import com.craft.tvshowme.infrastructure.adapters.TvShowRepositoryTMdB;
import com.craft.tvshowme.infrastructure.adapters.clients.tmdb.TMdBFeignClient;
import com.craft.tvshowme.infrastructure.adapters.clients.tmdb.configuration.TMdBFeignClientConfiguration;
import com.craft.tvshowme.infrastructure.adapters.clients.tmdb.converter.TMdBTvShowResponseToTvShowConverter;
import com.craft.tvshowme.infrastructure.adapters.clients.tmdb.converter.TMdBTvShowsPageResponseToTvShowsConverter;
import com.craft.tvshowme.infrastructure.adapters.clients.tmdb.dto.TMdBTvShowResponse;
import com.craft.tvshowme.infrastructure.adapters.clients.tmdb.dto.TMdBTvShowsPageResponse;
import com.craft.tvshowme.utils.TestingUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.MockitoAnnotations.openMocks;

public class TvShowRepositoryTMdBShould extends TestingUtils {

    private static final String API_KEY = "asdddddddd23423rcqwerftq345tf";
    private static final String LANGUAGE_EN = "en-US";
    private static final String PAGE_1 = "1";

    @Mock
    private TMdBFeignClient tMdBFeignClient;
    @Mock
    private TMdBFeignClientConfiguration tMdBFeignClientConfiguration;
    @Mock
    private TMdBTvShowsPageResponseToTvShowsConverter tMdBTvShowsPageResponseToTvShowsConverter;

    @Mock
    private TMdBTvShowResponseToTvShowConverter tMdBTvShowResponseToTvShowConverter;

    private TvShowRepositoryTMdB underTest;

    @BeforeEach
    void setUp() {
        openMocks(this);
        given(tMdBFeignClientConfiguration.getApiKey()).willReturn(API_KEY);
        given(tMdBFeignClientConfiguration.getLanguage()).willReturn(LANGUAGE_EN);
        underTest = new TvShowRepositoryTMdB(tMdBFeignClient, tMdBFeignClientConfiguration, tMdBTvShowsPageResponseToTvShowsConverter, tMdBTvShowResponseToTvShowConverter);
    }

    @Test
    void return_a_top_rated_list_of_tv_shows_as_a_TvShows_Optional() {
        //Given
        TMdBTvShowsPageResponse TMdBTvShowsPageResponse = mockTMDdBTvShowsPageResponse();
        TvShows tvShows = mockTvShows();
        given(tMdBFeignClient.getTopTvShows(API_KEY, LANGUAGE_EN, PAGE_1)).willReturn(TMdBTvShowsPageResponse);
        given(tMdBTvShowsPageResponseToTvShowsConverter.convert(any())).willReturn(tvShows);
        //When
        Optional<TvShows> response = underTest.getTopRatedTvShows(PAGE_1);

        //Then
        assertThat(response).isNotNull();
        assertThat(response.isPresent()).isTrue();
        then(tMdBFeignClient).should().getTopTvShows(API_KEY, LANGUAGE_EN, PAGE_1);

    }

    @Test
    void return_a_detailed_tv_show_as_optional() {
        //Given
        TMdBTvShowResponse tMdBTvShowResponse = mockTMdBShowResponse();
        TvShow tvShow = mockTvShowDetailed();
        given(tMdBFeignClient.getTvShow(1, API_KEY, LANGUAGE_EN)).willReturn(tMdBTvShowResponse);
        given(tMdBTvShowResponseToTvShowConverter.convert(any())).willReturn(tvShow);

        //When
        Optional<TvShow> response = underTest.getTvShow(1);

        //Then
        assertThat(response).isNotNull();
        assertThat(response.isPresent()).isTrue();
        then(tMdBFeignClient).should().getTvShow(1, API_KEY, LANGUAGE_EN);

    }
}
