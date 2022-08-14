package com.craft.tvshowme.infrastructure;

import com.craft.tvshowme.domain.model.TvShows;
import com.craft.tvshowme.infrastructure.adapters.TvShowRepositoryTMdB;
import com.craft.tvshowme.infrastructure.adapters.clients.tmdb.TMdBFeignClient;
import com.craft.tvshowme.infrastructure.adapters.clients.tmdb.configuration.TMdBFeignClientConfiguration;
import com.craft.tvshowme.infrastructure.adapters.clients.tmdb.converter.TMdBTvShowsPageResponseToTvShowsConverter;
import com.craft.tvshowme.infrastructure.adapters.clients.tmdb.dto.TMdBTvShowsPageResponse;
import com.craft.tvshowme.utils.TestingUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.MockitoAnnotations.openMocks;

public class TvShowRepositoryTMdBTest extends TestingUtils {

    private static final String API_KEY = "asdddddddd23423rcqwerftq345tf";
    private static final String LANGUAGE_EN = "en-US";
    private static final String PAGE_1 = "1";

    @Mock
    private TMdBFeignClient tMdBFeignClient;
    @Mock
    private TMdBFeignClientConfiguration tMdBFeignClientConfiguration;
    @Mock
    private TMdBTvShowsPageResponseToTvShowsConverter converter;

    private TvShowRepositoryTMdB underTest;

    @BeforeEach
    void setUp() {
        openMocks(this);
        underTest = new TvShowRepositoryTMdB(tMdBFeignClient, tMdBFeignClientConfiguration, converter);
    }

    @Test
    void should_return_list_of_tv_shows() {
        //Given
        TMdBTvShowsPageResponse TMdBTvShowsPageResponse = mockTMDdBTvShowsPageResponse();
        TvShows tvShows = mockTvShows();
        given(tMdBFeignClient.getTopTvShows(API_KEY, LANGUAGE_EN, PAGE_1)).willReturn(TMdBTvShowsPageResponse);
        given(converter.convert(any())).willReturn(tvShows);
        //When
        Optional<TvShows> response = underTest.getTvShows(PAGE_1);

        //Then
        assertThat(response).isNotNull();

    }

}
