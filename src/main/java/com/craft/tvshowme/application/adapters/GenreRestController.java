package com.craft.tvshowme.application.adapters;

import com.craft.tvshowme.application.dto.GenreDTO;
import com.craft.tvshowme.domain.ports.in.GenreService;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/genre")
@RequiredArgsConstructor
@Tag(name = "Genres")
public class GenreRestController {

    private final GenreService genreService;

    @GetMapping("/all")
    public ResponseEntity<List<GenreDTO>> getAllGenres(){
        return ResponseEntity.ok(genreService.getAllGenres().stream()
                .map(genre -> GenreDTO.valueOf(genre.name()))
                .collect(Collectors.toList()));
    }

}
