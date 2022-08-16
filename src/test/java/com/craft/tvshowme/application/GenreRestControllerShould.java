package com.craft.tvshowme.application;

import com.craft.tvshowme.application.adapters.GenreRestController;
import com.craft.tvshowme.application.dto.GenreDTO;
import com.craft.tvshowme.domain.model.Genre;
import com.craft.tvshowme.domain.ports.in.GenreService;
import com.craft.tvshowme.utils.TestingUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;
import java.util.stream.Collectors;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(GenreRestController.class)
public class GenreRestControllerShould extends TestingUtils {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private GenreService genreService;

    @Test
    void return_list_of_all_genres_allowed() throws Exception {
        //Given
        List<Genre> genres = mockListOfGenres();
        List<GenreDTO> genresDTO = genres.stream()
                .map(genre -> GenreDTO.valueOf(genre.name()))
                .collect(Collectors.toList());
        given(genreService.getAllGenres()).willReturn(genres);

        //When
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders
                .get("/api/v1/genre/all").accept(MediaType.APPLICATION_JSON));

        //Then
        resultActions.andDo(print())
                .andExpect(content().string(OBJECT_MAPPER.writeValueAsString(genresDTO)))
                .andExpect(status().isOk());

    }

}
