package com.craft.tvshowme.infrastructure.adapters.clients.tmdb.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class TMdBTvShowResponse {

    private Long id;
    private String name;
    @JsonProperty("vote_average")
    private Double voteAverage;
    private Double popularity;
    @JsonProperty("poster_path")
    private String posterPath;
    @JsonProperty("genre_ids")
    @JsonAlias("genres")
    private List<TmdbGenre> genres = new ArrayList<>();
    @JsonProperty("number_of_seasons")
    private Integer numberOfSeasons;
    @JsonProperty("number_of_episodes")
    private Integer numberOfEpisodes;
    private String overview;

}
