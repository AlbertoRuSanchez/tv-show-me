package com.craft.tvshowme.application.dto;

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
public class TvShowDTO {

    private Long id;
    private String name;
    private Double voteAverage;
    private Double popularity;
    private String poster;
    private List<GenreDTO> genres = new ArrayList<>();

}
