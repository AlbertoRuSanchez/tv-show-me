package com.craft.tvshowme.application;

import com.craft.tvshowme.application.dto.TvShowDTO;
import com.craft.tvshowme.application.dto.TvShowsDTO;
import com.craft.tvshowme.domain.model.TvShow;
import com.craft.tvshowme.domain.model.TvShows;
import com.craft.tvshowme.domain.ports.TvShowQueryService;
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

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(TvShowRestController.class)
public class TvShowRestControllerTest {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TvShowQueryService tvShowQueryService;

    @MockBean
    private ModelMapper modelMapper;

    @Test
    void should_call_getTvShows_and_return_TvShow_List_and_200_status() throws Exception {

        //Given
        TvShows tvShows = mockTvShows();
        TvShowsDTO tvShowsDTO = mockTvShowsDTO();
        String responseValue = OBJECT_MAPPER.writeValueAsString(tvShowsDTO);
        given(tvShowQueryService.getTvShows()).willReturn(tvShows);
        given(modelMapper.map(tvShows, TvShowsDTO.class)).willReturn(tvShowsDTO);

        //When
        ResultActions resultsActions = mockMvc.perform(
                MockMvcRequestBuilders.get("/api/v1/tv-show")
                        .accept(MediaType.parseMediaType("application/json;charset=UTF-8")));

        //Then
        resultsActions
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(responseValue));

    }

    private TvShows mockTvShows() {
        List<TvShow> tvShowList = List.of(TvShow.builder().id(1L).name("Breaking bad").build(), TvShow.builder().id(2L).name("Mr.Robot").build());
        TvShows tvShows = new TvShows();
        tvShows.setTvShows(tvShowList);
        return tvShows;
    }

    private TvShowsDTO mockTvShowsDTO() {
        List<TvShowDTO> tvShowList = List.of(TvShowDTO.builder().id(1L).name("Breaking bad").build(), TvShowDTO.builder().id(2L).name("Mr.Robot").build());
        TvShowsDTO tvShows = new TvShowsDTO();
        tvShows.setTvShows(tvShowList);
        return tvShows;
    }

}
