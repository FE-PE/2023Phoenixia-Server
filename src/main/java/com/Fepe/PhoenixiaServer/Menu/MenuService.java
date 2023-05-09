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
        Menu menu = modelMapper.map(menuDto, Menu.class);
        Menu createdMenu = menuRepository.save(menu);

        createdMenu.setFoodTruck(foodTruck);
        menuRepository.save(menu);

        foodTruck.getMenus().add(createdMenu);
        foodTruckRepository.save(foodTruck);

        return menu;
    }

    public Menu findMenuById(Integer id) {
        return menuRepository.findById(id)
                .orElseThrow(() -> new NullPointerException());
    }

    public Integer deleteMenuById(Integer id) {
        Menu menu = findMenuById(id);
        menuRepository.delete(menu);

        return id;
    }

    public Menu updateMenu(Integer menuId, MenuDto menuDto) {
        Menu menu = findMenuById(menuId);
        menu.setName(menuDto.getName());
        menu.setPrice(menuDto.getPrice());
        menu.setImageUrl(menuDto.getImageUrl());

        return menuRepository.save(menu);
    }
}
