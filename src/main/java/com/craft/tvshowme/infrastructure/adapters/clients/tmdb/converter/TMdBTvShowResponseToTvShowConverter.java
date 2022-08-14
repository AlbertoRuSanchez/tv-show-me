package com.craft.tvshowme.infrastructure.adapters.clients.tmdb.converter;

import com.craft.tvshowme.domain.model.TvShow;
import com.craft.tvshowme.infrastructure.adapters.clients.tmdb.dto.TMdBTvShowResponse;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TMdBTvShowResponseToTvShowConverter implements Converter<TMdBTvShowResponse, TvShow> {
    @Override
    public TvShow convert(TMdBTvShowResponse source) {

        TvShow tvShow = new TvShow();

        tvShow.setId(source.getId());
        tvShow.setName(source.getName());
        tvShow.setVoteAverage(source.getVoteAverage());

        return tvShow;
    }
}
