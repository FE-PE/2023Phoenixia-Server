package com.Fepe.PhoenixiaServer.foodtruck;

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
public class FoodTruckController {

    private final FoodTruckService foodTruckService;

    @GetMapping
    public ResponseEntity queryAllFoodTrucks() {
        List<FoodTruck> foodTrucks = this.foodTruckService.queryAllFoodTrucks();
        return ResponseEntity.ok().body(foodTrucks);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity getFoodTruck(@PathVariable Integer id) {
        FoodTruck foodTruck = this.foodTruckService.findFoodTruckById(id);
        return ResponseEntity.ok().body(foodTruck);
    }

    @PostMapping
    public ResponseEntity createFoodTruck(@RequestBody FoodTruckDto foodTruckDto) {
        FoodTruck foodTruck = this.foodTruckService.createFoodTruck(foodTruckDto);
        URI createdUri = linkTo(methodOn(FoodTruckController.class).createFoodTruck(foodTruckDto)).slash(foodTruck).toUri();

        return ResponseEntity.created(createdUri).body(foodTruck);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteFoodTruck(@PathVariable Integer id) {
        this.foodTruckService.deleteFoodTruckById(id);
        return ResponseEntity.ok().body(id);
    }
}
