package com.Fepe.PhoenixiaServer.foodtruck;

import com.Fepe.PhoenixiaServer.Menu.Menu;
import com.Fepe.PhoenixiaServer.Menu.MenuDto;
import com.Fepe.PhoenixiaServer.Menu.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/foodtruck")
@CrossOrigin
public class FoodTruckController {

    private final FoodTruckService foodTruckService;
    private final MenuService menuService;

    @GetMapping
    public ResponseEntity queryAllFoodTrucks() {
        List<FoodTruck> foodTrucks = foodTruckService.queryAllFoodTrucks();
        return ResponseEntity.ok().body(foodTrucks);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity getFoodTruck(@PathVariable Integer id) {
        FoodTruck foodTruck = foodTruckService.findFoodTruckById(id);
        return ResponseEntity.ok().body(foodTruck);
    }

    @PostMapping
    public ResponseEntity createFoodTruck(@RequestBody FoodTruckDto foodTruckDto) {
        FoodTruck foodTruck = foodTruckService.createFoodTruck(foodTruckDto);
        URI createdUri = linkTo(methodOn(FoodTruckController.class).createFoodTruck(foodTruckDto)).slash(foodTruck).toUri();

        return ResponseEntity.created(createdUri).body(foodTruck);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteFoodTruck(@PathVariable Integer id) {
        foodTruckService.deleteFoodTruckById(id);
        return ResponseEntity.ok().body(id);
    }

    @PostMapping(value = "/{id}/menu")
    public ResponseEntity createMenu(@RequestBody MenuDto menuDto, @PathVariable Integer id) {
        FoodTruck foodTruck = foodTruckService.findFoodTruckById(id);
        Menu menu = menuService.createMenu(menuDto, foodTruck);
        URI createdUri = linkTo(methodOn(FoodTruckController.class).createMenu(menuDto, id)).slash(foodTruck).toUri();
        return ResponseEntity.created(createdUri).body(menu);
    }

    @DeleteMapping(value = "/{foodtruckId}/menu/{menuId}")
    public ResponseEntity deleteMenu(@PathVariable Integer foodtruckId, @PathVariable Integer menuId) {
        FoodTruck foodTruck = foodTruckService.findFoodTruckById(foodtruckId);
        Menu menu = menuService.findMenuById(menuId);

        foodTruck.getMenus().remove(menu);
        menuService.deleteMenuById(menuId);

        return ResponseEntity.ok().body(menuId);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity updateFoodTruck(@PathVariable Integer foodtruckId, @RequestBody FoodTruckDto foodTruckDto) {
        FoodTruck foodTruck = foodTruckService.updateFoodTruck(foodtruckId, foodTruckDto);
        return ResponseEntity.ok().body(foodTruck);
    }

    @PatchMapping(value = "/{foodtruckId}/menu/{menuId}")
    public ResponseEntity updateMenu(@PathVariable Integer foodtruckId, @PathVariable Integer menuId, @RequestBody MenuDto menuDto) {
        Menu menu = menuService.updateMenu(menuId, menuDto);
        return ResponseEntity.ok().body(menu);
    }

    @GetMapping(value = "/{foodtruckId}/menu/{menuId}")
    public ResponseEntity getMenu(@PathVariable Integer foodtruckId, @PathVariable Integer menuId) {
        Menu menu = menuService.findMenuById(menuId);
        return ResponseEntity.ok().body(menu);
    }
}
