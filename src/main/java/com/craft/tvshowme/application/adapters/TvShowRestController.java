package com.craft.tvshowme.application.adapters;


import com.craft.tvshowme.application.dto.TvShowsDTO;
import com.craft.tvshowme.domain.ports.in.TvShowQueryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/tv-show")
@RequiredArgsConstructor
@Tag(name = "Tv shows")
public class TvShowRestController {

    private final TvShowQueryService tvShowQueryService;
    private final ModelMapper modelMapper;

    @GetMapping("/top-rated")
    @Operation(description = "Get a page from top-rated tv-shows list")
    public ResponseEntity<TvShowsDTO> getTvShows(@RequestParam String page){
        return ResponseEntity.ok(modelMapper.map(tvShowQueryService.getTopRatedTvShows(page), TvShowsDTO.class));
    }

}
