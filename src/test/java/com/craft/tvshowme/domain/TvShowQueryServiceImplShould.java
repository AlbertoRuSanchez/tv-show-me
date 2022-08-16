package com.craft.tvshowme.domain;

import com.craft.tvshowme.domain.error.TvShowNotFoundException;
import com.craft.tvshowme.domain.error.TvShowsNotFoundException;
import com.craft.tvshowme.domain.model.TvShow;
import com.craft.tvshowme.domain.model.TvShows;
import com.craft.tvshowme.domain.ports.out.TvShowRepository;
import com.craft.tvshowme.domain.service.TvShowQueryServiceImpl;
import com.craft.tvshowme.utils.TestingUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.MockitoAnnotations.openMocks;

public class TvShowQueryServiceImplShould extends TestingUtils {

    private static final String PAGE_1 = "1";

    @Mock
    private TvShowRepository tvShowRepository;

    private TvShowQueryServiceImpl underTest;

    @BeforeEach
    void setUp() {
        openMocks(this);
        underTest = new TvShowQueryServiceImpl(tvShowRepository);
    }

    @Test
    void return_a_page_of_list_of_top_rated_tv_shows() {
        //Given
        TvShows tvShows = mockTvShows();
        Optional<TvShows> tvShowsOptional = Optional.of(tvShows);
        given(tvShowRepository.getTopRatedTvShows(PAGE_1)).willReturn(tvShowsOptional);

        //When
        TvShows tvShowsResult = underTest.getTopRatedTvShows(PAGE_1);

        //Then
        assertThat(tvShowsResult).isNotNull();
        assertThat(tvShowsResult.getTvShows()).hasSameElementsAs(tvShows.getTvShows());
        then(tvShowRepository).should().getTopRatedTvShows(PAGE_1);
    }

    @Test
    void throw_TvShowsNotFoundException_when_getToRatedTvShows() {
        //Given
        given(tvShowRepository.getTopRatedTvShows(PAGE_1)).willReturn(Optional.empty());

        //When
        //Then
        assertThatThrownBy(() -> underTest.getTopRatedTvShows(PAGE_1))
                .isInstanceOf(TvShowsNotFoundException.class)
                .hasMessage("Tv shows not found");
    }

    @Test
    void return_detailed_tv_show_by_id(){
        //Given
        Optional<TvShow> tvShow = Optional.of(mockTvShowDetailed());
        given(tvShowRepository.getTvShow(1)).willReturn(tvShow);

        //When
        TvShow tvShowResult = underTest.getTvShow(1);

        //Then
        assertThat(tvShowResult).isNotNull();
        assertThat(tvShowResult.getId()).isEqualTo(tvShow.get().getId());
        assertThat(tvShowResult.getName()).isEqualTo(tvShow.get().getName());
        assertThat(tvShowResult.getGenres()).hasSameElementsAs(tvShow.get().getGenres());
    }

    @Test
    void throw_TvShowNotFoundException_when_getTvShow_by_id() {
        //Given
        given(tvShowRepository.getTvShow(1)).willReturn(Optional.empty());

        //When
        //Then
        assertThatThrownBy(() -> underTest.getTvShow(1))
                .isInstanceOf(TvShowNotFoundException.class)
                .hasMessage("Tv show not found");
    }
}
