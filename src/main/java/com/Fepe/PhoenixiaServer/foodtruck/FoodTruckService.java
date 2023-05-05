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
        FoodTruck foodTruck = this.modelMapper.map(foodTruckDto, FoodTruck.class);
        return this.foodTruckRepository.save(foodTruck);
    }


    public List<FoodTruck> queryAllFoodTrucks() {
        return this.foodTruckRepository.findAll();
    }

    public FoodTruck findFoodTruckById(Integer id) {
        return this.foodTruckRepository.findById(id)
                .orElseThrow(() -> new NullPointerException());
    }

    public Integer deleteFoodTruckById(Integer id) {
        FoodTruck foodTruck = this.findFoodTruckById(id);
        this.foodTruckRepository.delete(foodTruck);

        return id;
    }
}
