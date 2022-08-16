package com.craft.tvshowme.application.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TvShowDTO {

    private Long id;
    private String name;
    private Double voteAverage;
    private Double popularity;
    private String poster;
    private List<GenreDTO> genres = new ArrayList<>();
    private Integer numberOfSeasons;
    private Integer numberOfEpisodes;
    private String overview;
}
