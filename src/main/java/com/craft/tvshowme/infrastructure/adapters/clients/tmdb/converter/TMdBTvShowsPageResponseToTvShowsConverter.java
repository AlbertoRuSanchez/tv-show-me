package com.craft.tvshowme.infrastructure.adapters.clients.tmdb.converter;

import com.craft.tvshowme.domain.model.TvShow;
import com.craft.tvshowme.domain.model.TvShows;
import com.craft.tvshowme.infrastructure.adapters.clients.tmdb.dto.TMdBTvShowsPageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class TMdBTvShowsPageResponseToTvShowsConverter implements Converter<TMdBTvShowsPageResponse, TvShows> {

    private final TMdBTvShowResponseToTvShowConverter tvShowConverter;

    @Override
    public TvShows convert(TMdBTvShowsPageResponse source) {

        TvShows tvShows = new TvShows();
        tvShows.setPage(source.getPage());
        tvShows.setTotalPages(source.getTotalPages());
        tvShows.setTotalTvShows(source.getTotalResults());
        tvShows.setTotalPages(source.getTotalPages());

        List<TvShow> tvShowList = new ArrayList<>();
        if(!CollectionUtils.isEmpty(source.getResults())){
            source.getResults().forEach(result -> tvShowList.add(tvShowConverter.convert(result)));
        }
        tvShows.setTvShows(tvShowList);

        return tvShows;
    }
}
