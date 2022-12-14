package com.craft.tvshowme.domain.ports.in;

import com.craft.tvshowme.domain.model.TvShow;
import com.craft.tvshowme.domain.model.TvShows;

public interface TvShowQueryService {
    TvShows getTopRatedTvShows(String page);

    TvShow getTvShow(Integer id);
}
