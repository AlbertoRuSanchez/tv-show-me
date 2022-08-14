package com.craft.tvshowme.infrastructure.adapters.clients.tmdb;

import com.craft.tvshowme.infrastructure.adapters.clients.tmdb.dto.TMdBTvShowsPageResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "tmdb-service", url = "https://api.themoviedb.org/3")
public interface TMdBFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/tv/top_rated", consumes = MediaType.APPLICATION_JSON_VALUE)
    TMdBTvShowsPageResponse getTopTvShows(@RequestParam(value = "api_key") String apiKey, @RequestParam String language, @RequestParam String page);
}
