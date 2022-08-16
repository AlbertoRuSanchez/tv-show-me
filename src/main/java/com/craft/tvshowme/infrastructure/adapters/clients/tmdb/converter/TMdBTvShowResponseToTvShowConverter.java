package com.craft.tvshowme.infrastructure.adapters.clients.tmdb.converter;

import com.craft.tvshowme.domain.model.Genre;
import com.craft.tvshowme.domain.model.TvShow;
import com.craft.tvshowme.infrastructure.adapters.clients.tmdb.dto.TMdBTvShowResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class TMdBTvShowResponseToTvShowConverter implements Converter<TMdBTvShowResponse, TvShow> {

    private static final String URL_IMAGES = "https://image.tmdb.org/t/p/w500";

    @Override
    public TvShow convert(TMdBTvShowResponse source) {

        TvShow tvShow = new TvShow();

        tvShow.setId(source.getId());
        tvShow.setName(source.getName());
        tvShow.setVoteAverage(source.getVoteAverage());
        tvShow.setPopularity(source.getPopularity());
        if (StringUtils.hasText(source.getPosterPath())) {
            tvShow.setPoster(URL_IMAGES + source.getPosterPath());
        }

        List<Genre> genres = new ArrayList<>();
        if (CollectionUtils.isEmpty(source.getGenres())) {
            genres.add(Genre.UNKNOWN);
        } else {
            source.getGenres().forEach(tmdbGenre -> genres.add(convertGenreTmdbToGenreDomain(tmdbGenre.getId())));
        }
        tvShow.setGenres(genres);

        return tvShow;
    }

    private Genre convertGenreTmdbToGenreDomain(Integer id) {
        switch (id) {
            case 16:
                return Genre.ANIMATION;
            case 18:
                return Genre.DRAMA;
            case 35:
                return Genre.COMEDY;
            case 37:
                return Genre.WESTERN;
            case 80:
                return Genre.CRIME;
            case 99:
                return Genre.DOCUMENTARY;
            case 9648:
                return Genre.MYSTERY;
            case 10759:
                return Genre.ACTION_AND_ADVENTURE;
            case 10751:
                return Genre.FAMILY;
            case 10762:
                return Genre.KIDS;
            case 10763:
                return Genre.NEWS;
            case 10764:
                return Genre.REALITY;
            case 10765:
                return Genre.SCIFI_AND_FANTASY;
            case 10766:
                return Genre.SOAP;
            case 10767:
                return Genre.TALK;
            case 10768:
                return Genre.WAR_AND_POLITICS;
        }
        return Genre.UNKNOWN;
    }

}
