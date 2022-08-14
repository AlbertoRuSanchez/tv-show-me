package com.craft.tvshowme.infrastructure.adapters.clients.tmdb.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TMdBTvShowsPageResponse {

    private Integer page;
    private Integer totalPages;
    private Integer totalResults;
    private List<TMdBTvShowResponse> results;

}
