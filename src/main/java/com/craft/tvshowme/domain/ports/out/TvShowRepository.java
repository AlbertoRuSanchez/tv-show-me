package com.craft.tvshowme.domain.ports.out;

import com.craft.tvshowme.domain.model.TvShow;
import com.craft.tvshowme.domain.model.TvShows;

import java.util.Optional;

public interface TvShowRepository {
   Optional<TvShows> getTopRatedTvShows(String page);
   Optional<TvShow> getTvShow(Integer id);
}
