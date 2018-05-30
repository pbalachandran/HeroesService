package com.hero.acceptance;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = com.hero.HeroesService.class)
@AutoConfigureMockMvc
public class HeroAcceptanceTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getHeroes_returnsHeroViewModels() throws Exception {
        mockMvc.perform(get("/api/heroes")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", is(11)))
                .andExpect(jsonPath("$[0].name", is("Mr. Nice")))
                .andExpect(jsonPath("$[9].id", is(20)))
                .andExpect(jsonPath("$[9].name", is("Tornado")));
    }

    @Test
    public void getHero_whenGivenAnId_returnsHeroViewModel() throws Exception {
        mockMvc.perform(get("/api/hero/11")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(11)))
                .andExpect(jsonPath("$.name", is("Mr. Nice")));
    }
}
