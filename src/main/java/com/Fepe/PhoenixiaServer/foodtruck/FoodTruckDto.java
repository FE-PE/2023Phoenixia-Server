package com.Fepe.PhoenixiaServer.foodtruck;

import com.Fepe.PhoenixiaServer.Menu.Menu;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data @Builder
@Getter @Setter
public class FoodTruckDto {

    private String name;

    private String description;

    private String imageUrl;

}
