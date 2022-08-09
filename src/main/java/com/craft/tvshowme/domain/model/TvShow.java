package com.craft.tvshowme.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TvShow {
    private Long id;
    private String name;
}
