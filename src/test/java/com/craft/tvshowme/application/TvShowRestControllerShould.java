package com.craft.tvshowme.application;

import com.craft.tvshowme.application.adapters.TvShowRestController;
import com.craft.tvshowme.application.dto.TvShowDTO;
import com.craft.tvshowme.application.dto.TvShowsDTO;
import com.craft.tvshowme.domain.model.TvShow;
import com.craft.tvshowme.domain.model.TvShows;
import com.craft.tvshowme.domain.ports.in.TvShowQueryService;
import com.craft.tvshowme.utils.TestingUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(TvShowRestController.class)
public class TvShowRestControllerShould extends TestingUtils {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private static final String PAGE_1 = "1";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TvShowQueryService tvShowQueryService;

    @MockBean
    private ModelMapper modelMapper;

    @Test
    void call_getTvShows_and_return_TvShow_List_page_with_200_status() throws Exception {

        //Given
        TvShows tvShows = mockTvShows();
        TvShowsDTO tvShowsDTO = mockTvShowsDTO();
        String responseValue = OBJECT_MAPPER.writeValueAsString(tvShowsDTO);
        given(tvShowQueryService.getTopRatedTvShows(PAGE_1)).willReturn(tvShows);
        given(modelMapper.map(tvShows, TvShowsDTO.class)).willReturn(tvShowsDTO);

        //When
        ResultActions resultsActions = mockMvc.perform(
                MockMvcRequestBuilders.get("/api/v1/tv-show/top-rated")
                        .accept(MediaType.APPLICATION_JSON)
                        .param("page", "1"));

        //Then
        resultsActions
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(responseValue));

    }

    @Test
    void return_details_from_a_tv_show() throws Exception {
        //Given
        TvShowDTO tvShowDTO = mockTvShowDTODetailed();
        TvShow tvShow = mockTvShowDetailed();
        given(tvShowQueryService.getTvShow(anyInt())).willReturn(tvShow);
        given(modelMapper.map(tvShow, TvShowDTO.class)).willReturn(tvShowDTO);

        //When
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/tv-show/{id}", 94605)
                .accept(MediaType.APPLICATION_JSON));

        //Then
        resultActions.andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(OBJECT_MAPPER.writeValueAsString(tvShowDTO)));
    }
}
