package com.craft.tvshowme.application;

import com.craft.tvshowme.application.adapters.TvShowRestController;
import com.craft.tvshowme.application.dto.TvShowsDTO;
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
                MockMvcRequestBuilders.get("/api/v1/tv-show")
                        .accept(MediaType.parseMediaType("application/json;charset=UTF-8"))
                        .param("page", "1"));

        //Then
        resultsActions
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(responseValue));

    }

}
