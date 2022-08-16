package com.craft.tvshowme.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TvShow {
    private Long id;
    private String name;
    private Double voteAverage;
    private Double popularity;
    private String poster;
    private List<Genre> genres = new ArrayList<>();
}
