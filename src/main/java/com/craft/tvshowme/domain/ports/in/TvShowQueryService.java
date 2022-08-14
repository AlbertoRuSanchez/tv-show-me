package com.craft.tvshowme.domain.ports.in;

import com.craft.tvshowme.domain.model.TvShows;

public interface TvShowQueryService {
    TvShows getTvShows(String page);

}
