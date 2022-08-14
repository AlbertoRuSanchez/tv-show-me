package com.craft.tvshowme.infrastructure.adapters.clients.tmdb.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TMdBTvShowResponse {

    private Long id;
    private String name;
    private Double voteAverage;

}
