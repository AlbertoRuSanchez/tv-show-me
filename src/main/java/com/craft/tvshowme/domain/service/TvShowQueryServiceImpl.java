package com.craft.tvshowme.domain.service;

import com.craft.tvshowme.domain.model.TvShow;
import com.craft.tvshowme.domain.model.TvShows;
import com.craft.tvshowme.domain.ports.TvShowQueryService;

import java.util.List;


public class TvShowQueryServiceImpl implements TvShowQueryService {

    public TvShowQueryServiceImpl() {
    }

    @Override
    public TvShows getTvShows() {
        List<TvShow> tvShowList = List.of(TvShow.builder().id(1L).name("Breaking bad").build(), TvShow.builder().id(2L).name("Mr.Robot").build());
        TvShows tvShows = new TvShows();
        tvShows.setTvShows(tvShowList);
        return tvShows;
    }
}
