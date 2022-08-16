package com.craft.tvshowme.domain.ports.in;

import com.craft.tvshowme.domain.model.Genre;

import java.util.List;

public interface GenreService {

    List<Genre> getAllGenres();

}
