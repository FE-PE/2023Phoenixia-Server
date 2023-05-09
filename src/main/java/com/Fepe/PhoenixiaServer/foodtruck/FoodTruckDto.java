package com.Fepe.PhoenixiaServer.foodtruck;

import com.Fepe.PhoenixiaServer.Menu.Menu;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Builder
public class FoodTruckDto {

    private String name;

    private String description;

    private String imageUrl;

}
