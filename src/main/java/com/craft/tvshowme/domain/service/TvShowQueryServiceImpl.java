package com.craft.tvshowme.domain.service;

import com.craft.tvshowme.domain.error.TvShowsNotFoundException;
import com.craft.tvshowme.domain.model.TvShows;
import com.craft.tvshowme.domain.ports.in.TvShowQueryService;
import com.craft.tvshowme.domain.ports.out.TvShowRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

public class TvShowQueryServiceImpl implements TvShowQueryService {

    private final TvShowRepository tvShowRepository;

    public TvShowQueryServiceImpl(TvShowRepository tvShowRepository) {
        this.tvShowRepository = tvShowRepository;
    }

    @Override
    public TvShows getTvShows(String page) {
        Optional<TvShows> tvShows = tvShowRepository.getTvShows(page);
        if(tvShows.isEmpty()){
            throw new TvShowsNotFoundException();
        }
        return tvShows.get();
    }
}
