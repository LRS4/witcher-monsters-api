package com.example.monsters.controller;

import com.example.monsters.model.Category;
import com.example.monsters.model.Monster;
import com.example.monsters.repository.CategoryRepository;
import com.example.monsters.repository.MonsterRepository;
import com.example.monsters.service.MonsterService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class MonsterControllerTests {

    //region Private properties

    @Value("${MONSTERS_API_ADMIN_KEY}")
    private String apiAdminKey;

    //endregion

    //region Mock Dependencies

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    MonsterService monsterService;

    @MockBean
    MonsterRepository monsterRepository;

    @MockBean
    CategoryRepository categoryRepository;

    //endregion

    //region Tests

    @Test
    void getMonsters() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/v1/monster")
                .contentType("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getMonstersByCategory() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/v1/monster/category/beasts")
                .contentType("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getMonster() throws Exception {
        Monster forktail = new Monster(
                "test",
                "Test",
                "test",
                "https://res.cloudinary.com/dayqxxsip/image/upload/v1613822220/App%20Images/Witcher%203%20Bestiary/Beasts/654_brssrh.png",
                "test",
                "test",
                "test",
                LocalDate.now(),
                new Category("draconid", "Draconid")
        );

        when(monsterRepository.findMonsterByName("forktail"))
                .thenReturn(Optional.of(forktail));

        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/v1/monster/forktail")
                .contentType("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getMonsterCategories() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/v1/monster/categories/all")
                .contentType("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @Order(1)
    void addNewMonster() throws Exception {
        Category beasts = new Category("beasts", "Beasts");

        Monster testMonster = new Monster(
                "test",
                "Test",
                "test",
                "https://res.cloudinary.com/dayqxxsip/image/upload/v1613822220/App%20Images/Witcher%203%20Bestiary/Beasts/654_brssrh.png",
                "test",
                "test",
                "test",
                LocalDate.now(),
                beasts
        );

        when(categoryRepository.findCategoryByName(anyString())).thenReturn(beasts);

        mockMvc.perform(MockMvcRequestBuilders
                .post("/api/v1/monster/category/beasts")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(testMonster))
                .header("x-api-key", apiAdminKey))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void deleteMonster() throws Exception {
        when(monsterRepository.existsById(anyLong())).thenReturn(true);

        doNothing().when(monsterRepository).deleteById(anyLong());

        mockMvc.perform(MockMvcRequestBuilders
                .delete("/api/v1/monster/5")
                .contentType("application/json")
                .header("x-api-key", apiAdminKey))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void updateMonster() throws Exception {
        Category beasts = new Category("beasts", "Beasts");

        Monster testMonster = new Monster(
                5L,
                "test123",
                "Test123",
                "test123",
                "https://res.cloudinary.com/dayqxxsip/image/upload/v1613822220/App%20Images/Witcher%203%20Bestiary/Beasts/654_brssrh.png",
                "test123",
                "test123",
                "test123",
                LocalDate.now(),
                beasts
        );

        when(monsterRepository.findById(anyLong())).thenReturn(Optional.of(testMonster));
        when(categoryRepository.findById(anyLong())).thenReturn(Optional.of(beasts));

        mockMvc.perform(MockMvcRequestBuilders
                .put("/api/v1/monster/{monsterId}/{categoryId}", 5, 1)
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(testMonster))
                .header("x-api-key", apiAdminKey))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(monsterRepository, times(1)).findById(testMonster.getId());
    }

    //endregion
}