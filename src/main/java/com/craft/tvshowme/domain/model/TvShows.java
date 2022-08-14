package com.craft.tvshowme.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class TvShows {
    private Integer page;
    private Integer totalPages;
    private Integer totalTvShows;
    private List<TvShow> tvShows;
}
