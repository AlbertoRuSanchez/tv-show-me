package com.craft.tvshowme.domain.service;

import com.craft.tvshowme.domain.model.Genre;
import com.craft.tvshowme.domain.ports.in.GenreService;

import java.util.Arrays;
import java.util.List;

public class GenreServiceImpl implements GenreService {

    @Override
    public List<Genre> getAllGenres() {
        return Arrays.stream(Genre.values()).toList();
    }
}
