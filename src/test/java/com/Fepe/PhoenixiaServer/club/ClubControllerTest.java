package com.Fepe.PhoenixiaServer.club;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.RestController;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
class ClubControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    ClubService clubService;

    @BeforeEach
    public void setUp() {

        ClubDto club1 = ClubDto.builder()
                .number(1)
                .name("aa")
                .description("bb")
                .build();
        this.clubService.createClub(club1);

        ClubDto club2 = ClubDto.builder()
                .number(2)
                .name("cc")
                .description("dd")
                .build();
        this.clubService.createClub(club2);
    }

    @Test
    public void createClub() throws Exception {
        ClubDto club = ClubDto.builder()
                .number(3)
                .name("ee")
                .description("ff")
                .build();

        mockMvc.perform(post("/api/club")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(club)))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    public void findAllClubs() throws Exception {
        mockMvc.perform(get("/api/club"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void findClub() throws Exception {
        mockMvc.perform(get("/api/club/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void deleteClub() throws Exception {
        mockMvc.perform(delete("/api/club/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

}