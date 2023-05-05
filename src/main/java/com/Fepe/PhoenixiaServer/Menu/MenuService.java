package com.Fepe.PhoenixiaServer.Menu;

import com.Fepe.PhoenixiaServer.foodtruck.FoodTruck;
import com.Fepe.PhoenixiaServer.foodtruck.FoodTruckRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository menuRepository;
    private final FoodTruckRepository foodTruckRepository;
    private final ModelMapper modelMapper;

    public Menu createMenu(MenuDto menuDto, FoodTruck foodTruck) {
        Menu menu = this.modelMapper.map(menuDto, Menu.class);
        Menu createdMenu = this.menuRepository.save(menu);

        createdMenu.setFoodTruck(foodTruck);
        this.menuRepository.save(menu);

        foodTruck.getMenus().add(createdMenu);
        this.foodTruckRepository.save(foodTruck);

        return menu;
    }

    public Menu findMenuById(Integer id) {
        return this.menuRepository.findById(id)
                .orElseThrow(() -> new NullPointerException());
    }

    public Integer deleteMenuById(Integer id) {
        Menu menu = this.findMenuById(id);
        this.menuRepository.delete(menu);

        return id;
    }
}
