package com.craft.tvshowme.application.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class TvShowsDTO {
    private List<TvShowDTO> tvShows;
}
