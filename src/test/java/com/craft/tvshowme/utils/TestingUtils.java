package com.craft.tvshowme.utils;

import com.craft.tvshowme.application.dto.TvShowDTO;
import com.craft.tvshowme.application.dto.TvShowsDTO;
import com.craft.tvshowme.domain.model.TvShow;
import com.craft.tvshowme.domain.model.TvShows;
import com.craft.tvshowme.infrastructure.adapters.clients.tmdb.dto.TMdBTvShowsPageResponse;
import com.craft.tvshowme.infrastructure.adapters.clients.tmdb.dto.TMdBTvShowResponse;

import java.util.List;

public class TestingUtils {

    protected TvShows mockTvShows() {
        List<TvShow> tvShowList = List.of(TvShow.builder().id(1L).name("Breaking bad").build(), TvShow.builder().id(2L).name("Mr.Robot").build());
        TvShows tvShows = new TvShows();
        tvShows.setTvShows(tvShowList);
        return tvShows;
    }

    protected TvShowsDTO mockTvShowsDTO() {
        List<TvShowDTO> tvShowList = List.of(TvShowDTO.builder().id(1L).name("Breaking bad").build(), TvShowDTO.builder().id(2L).name("Mr.Robot").build());
        TvShowsDTO tvShows = new TvShowsDTO();
        tvShows.setTvShows(tvShowList);
        return tvShows;
    }

    protected TMdBTvShowsPageResponse mockTMDdBTvShowsPageResponse() {

        TMdBTvShowsPageResponse TMdBTvShowsPageResponse = new TMdBTvShowsPageResponse();
        TMdBTvShowsPageResponse.setPage(1);
        TMdBTvShowsPageResponse.setTotalPages(250);
        TMdBTvShowsPageResponse.setTotalResults(2000);

        List<TMdBTvShowResponse> tMdBTvShowResponses;

        TMdBTvShowResponse tMdBTvShowResponseOne = new TMdBTvShowResponse();
        tMdBTvShowResponseOne.setId(1L);
        tMdBTvShowResponseOne.setName("Mr.Robot");
        tMdBTvShowResponseOne.setVoteAverage(9.4);

        TMdBTvShowResponse tMdBTvShowResponseTwo = new TMdBTvShowResponse();
        tMdBTvShowResponseOne.setId(2L);
        tMdBTvShowResponseOne.setName("Breaking bad");
        tMdBTvShowResponseOne.setVoteAverage(9.9);

        TMdBTvShowResponse tMdBTvShowResponseThree = new TMdBTvShowResponse();
        tMdBTvShowResponseOne.setId(3L);
        tMdBTvShowResponseOne.setName("Rings of power");
        tMdBTvShowResponseOne.setVoteAverage(9.1);

        tMdBTvShowResponses = List.of(tMdBTvShowResponseOne, tMdBTvShowResponseTwo, tMdBTvShowResponseThree);

        TMdBTvShowsPageResponse.setResults(tMdBTvShowResponses);
        return TMdBTvShowsPageResponse;
    }

}
