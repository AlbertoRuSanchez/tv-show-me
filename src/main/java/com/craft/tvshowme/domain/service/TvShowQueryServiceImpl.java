package com.craft.tvshowme.domain.service;

import com.craft.tvshowme.domain.error.TvShowNotFoundException;
import com.craft.tvshowme.domain.error.TvShowsNotFoundException;
import com.craft.tvshowme.domain.model.TvShow;
import com.craft.tvshowme.domain.model.TvShows;
import com.craft.tvshowme.domain.ports.in.TvShowQueryService;
import com.craft.tvshowme.domain.ports.out.TvShowRepository;

import java.util.Optional;

public class TvShowQueryServiceImpl implements TvShowQueryService {

    private final TvShowRepository tvShowRepository;

    public TvShowQueryServiceImpl(TvShowRepository tvShowRepository) {
        this.tvShowRepository = tvShowRepository;
    }

    @Override
    public TvShows getTopRatedTvShows(String page) {
        Optional<TvShows> tvShows = tvShowRepository.getTopRatedTvShows(page);
        if(tvShows.isEmpty()){
            throw new TvShowsNotFoundException();
        }
        return tvShows.get();
    }

    @Override
    public TvShow getTvShow(Integer id) {
        Optional<TvShow> tvShow = tvShowRepository.getTvShow(id);
        if(tvShow.isEmpty()){
            throw new TvShowNotFoundException();
        }
        return tvShow.get();
    }
}
