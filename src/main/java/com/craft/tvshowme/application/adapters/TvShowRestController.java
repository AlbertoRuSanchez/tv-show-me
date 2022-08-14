package com.craft.tvshowme.application.adapters;


import com.craft.tvshowme.application.dto.TvShowsDTO;
import com.craft.tvshowme.domain.ports.in.TvShowQueryService;
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
public class TvShowRestController {

    private final TvShowQueryService tvShowQueryService;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<TvShowsDTO> getTvShows(@RequestParam String page){
        return ResponseEntity.ok(modelMapper.map(tvShowQueryService.getTvShows(page), TvShowsDTO.class));
    }

}
