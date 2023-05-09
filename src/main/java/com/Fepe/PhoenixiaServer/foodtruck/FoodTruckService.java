package com.Fepe.PhoenixiaServer.foodtruck;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodTruckService {

    private final FoodTruckRepository foodTruckRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public FoodTruck createFoodTruck(FoodTruckDto foodTruckDto) {
        FoodTruck foodTruck = modelMapper.map(foodTruckDto, FoodTruck.class);
        return foodTruckRepository.save(foodTruck);
    }


    public List<FoodTruck> queryAllFoodTrucks() {
        return foodTruckRepository.findAll();
    }

    public FoodTruck findFoodTruckById(Integer id) {
        return foodTruckRepository.findById(id)
                .orElseThrow(() -> new NullPointerException());
    }

    public Integer deleteFoodTruckById(Integer id) {
        FoodTruck foodTruck = findFoodTruckById(id);
        foodTruckRepository.delete(foodTruck);

        return id;
    }

    public FoodTruck updateFoodTruck(Integer truckId, FoodTruckDto foodTruckDto) {
        FoodTruck foodTruck = findFoodTruckById(truckId);
        foodTruck.setName(foodTruckDto.getName());
        foodTruck.setDescription(foodTruckDto.getDescription());
        foodTruck.setImageUrl(foodTruckDto.getImageUrl());

        return foodTruckRepository.save(foodTruck);
    }
}
