package com.Fepe.PhoenixiaServer.foodtruck;

import com.Fepe.PhoenixiaServer.Menu.Menu;
import com.Fepe.PhoenixiaServer.Menu.MenuDto;
import com.Fepe.PhoenixiaServer.Menu.MenuRepository;
import com.Fepe.PhoenixiaServer.Menu.MenuService;
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

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
class FoodTruckControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    MenuRepository menuRepository;
    @Autowired
    MenuService menuService;
    @Autowired
    FoodTruckRepository foodTruckRepository;
    @Autowired
    FoodTruckService foodTruckService;
    @Autowired
    ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        FoodTruckDto foodTruckDto = FoodTruckDto.builder()
                .name("truckname")
                .description("description")
                .imageUrl("aasd")
                .build();
        FoodTruck createdTruck = this.foodTruckService.createFoodTruck(foodTruckDto);

        MenuDto menu1Dto = MenuDto.builder()
                .name("타코야키")
                .price(3000)
                .build();
        this.menuService.createMenu(menu1Dto, createdTruck);
        MenuDto menu2Dto = MenuDto.builder()
                .name("아이스크림")
                .price(3000)
                .build();
        this.menuService.createMenu(menu2Dto, createdTruck);
    }

    @Test
    public void findFoodTruckById() throws Exception {

        mockMvc.perform(get("/api/foodtruck/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void queryAllTrucks() throws Exception {
        mockMvc.perform(get("/api/foodtruck")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void createFoodTruck() throws Exception {
        FoodTruckDto foodTruckDto = FoodTruckDto.builder()
                .name("aaa")
                .description("bbb")
                .imageUrl("ddd")
                .build();

        mockMvc.perform(post("/api/foodtruck")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(this.objectMapper.writeValueAsString(foodTruckDto)))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    public void menuCreate() throws Exception {

        FoodTruck foodTruck = this.foodTruckService.queryAllFoodTrucks().get(0);

        MenuDto menuDto = MenuDto.builder()
                .name("아이스크림")
                .price(3000)
                .build();

        mockMvc.perform(post("/api/foodtruck/1/menu")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(menuDto)))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    public void deleteTruck() throws Exception {
        FoodTruckDto foodTruckDto = FoodTruckDto.builder()
                .name("aaa")
                .description("bbb")
                .imageUrl("ddd")
                .build();
        this.foodTruckService.createFoodTruck(foodTruckDto);

        mockMvc.perform(delete("/api/foodtruck/2"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void deleteMenu() throws Exception {
        mockMvc.perform(delete("/api/foodtruck/1/menu/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}