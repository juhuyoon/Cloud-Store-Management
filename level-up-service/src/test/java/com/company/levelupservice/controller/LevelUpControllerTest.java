package com.company.levelupservice.controller;

import com.company.levelupservice.model.LevelViewModel;
import com.company.levelupservice.service.ServiceLayer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.sql.DataSource;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(LevelUpController.class)
public class LevelUpControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ServiceLayer serviceLayer;

    @MockBean
    private DataSource dataSource;

    @InjectMocks
    private LevelUpControllerTest levelUpControllerTest;

    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp() throws Exception {
    }

    private void setServiceLayer(){
        serviceLayer = mock(ServiceLayer.class);

        //view model - no id
        LevelViewModel lvm1New = new LevelViewModel(
                1,
                20,
                LocalDate.of(2000,01,01)
        );

        LevelViewModel lvm2New = new LevelViewModel(
                2,
                42,
                LocalDate.of(2000,02,02)
        );
        //view model - saved
        LevelViewModel lvm1Saved = new LevelViewModel(
                1,
                1,
                20,
                LocalDate.of(2000,01,01)
        );

        LevelViewModel lvm2Saved = new LevelViewModel(
                2,
                2,
                42,
                LocalDate.of(2000,02,02)
        );
        List<LevelViewModel> expectedLvm = new ArrayList<>();
        expectedLvm.add(lvm1Saved);
        expectedLvm.add(lvm2Saved);

        doReturn(lvm1Saved).when(serviceLayer).addLevelUpEntry(lvm1New);
        doReturn(lvm2Saved).when(serviceLayer).addLevelUpEntry(lvm2New);
        doReturn(lvm1Saved).when(serviceLayer).findLevelUpEntry(1);
        doReturn(lvm2Saved).when(serviceLayer).findLevelUpEntry(2);
        doReturn(expectedLvm).when(serviceLayer).findAllLevelUpEntries();
        doNothing().when(serviceLayer).updateLevelUpEntry(any(LevelViewModel.class));
        doNothing().when(serviceLayer).removeLevelUpEntry(anyInt());
    }

    @Test
    public void createLevelUp() throws Exception {
        LevelViewModel lvm1New = new LevelViewModel(
                1,
                20,
                LocalDate.of(2000,01,01)
        );
        String inputJson = mapper.writeValueAsString(lvm1New);

        LevelViewModel lvm1Saved = new LevelViewModel(
                1,
                1,
                20,
                LocalDate.of(2000,01,01)
        );
        String outputJson = mapper.writeValueAsString(lvm1Saved);

        this.mockMvc.perform(post("/level-up")
            .content(inputJson)
            .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson)
        );
    }

    @Test
    public void getAllLevelUp() throws Exception {
        LevelViewModel lvm1Saved = new LevelViewModel(
                1,
                1,
                20,
                LocalDate.of(2000,01,01)
        );

        LevelViewModel lvm2Saved = new LevelViewModel(
                2,
                2,
                42,
                LocalDate.of(2000,02,02)
        );
        List<LevelViewModel> expectedLvm = new ArrayList<>();
        expectedLvm.add(lvm1Saved);
        expectedLvm.add(lvm2Saved);

        String outputJson = mapper.writeValueAsString(expectedLvm);

        this.mockMvc.perform(get("/level-up"))
                .andDo(print())
                .andExpect(status().isFound())
                .andExpect(content().json(outputJson)
        );
    }

    @Test
    public void getLevelUp() throws Exception {
        LevelViewModel lvm1Saved = new LevelViewModel(
                1,
                1,
                20,
                LocalDate.of(2000,01,01)
        );

        String outputJson = mapper.writeValueAsString(lvm1Saved);

        this.mockMvc.perform(get("/level-up/1"))
                .andDo(print())
                .andExpect(status().isFound())
                .andExpect(content().json(outputJson)
        );
    }

    @Test
    public void updateLevelUp() throws Exception {
        LevelViewModel lvm1Update = new LevelViewModel(
                1,
                1,
                100,
                LocalDate.of(2000,01,01)
        );
        String inputJson = mapper.writeValueAsString(lvm1Update);

        this.mockMvc.perform(put("/level-up/1")
            .content(inputJson)
            .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk()
        );
    }

    @Test
    public void deleteLevelUp() throws Exception {

        //levelUpControllerTest.deleteLevelUp();

        this.mockMvc.perform(delete("/level-up/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}