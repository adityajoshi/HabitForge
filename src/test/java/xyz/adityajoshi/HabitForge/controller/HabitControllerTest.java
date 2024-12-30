package xyz.adityajoshi.HabitForge.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest()
@AutoConfigureMockMvc
class HabitControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void simpleTest() throws Exception {
        this.mockMvc.perform(get("/habits/")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void insertTest() throws Exception {
        this.mockMvc.perform(post("/habits/insert")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"taskName\": \"new test\"}")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void updateByIdTest() throws Exception {
        this.mockMvc.perform(put("/habits/update/")
                        .param("id", "1")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void deleteByIdTest() throws Exception {
        this.mockMvc.perform(delete("/habits/delete/")
                        .param("id", "1")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void selectByIdTest() throws Exception {
        this.mockMvc.perform(get("/habits/select/")
                        .param("id", "1")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk());
    }
}