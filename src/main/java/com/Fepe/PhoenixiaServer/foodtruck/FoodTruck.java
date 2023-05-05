package com.Fepe.PhoenixiaServer.foodtruck;

import com.Fepe.PhoenixiaServer.Menu.Menu;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Entity
@Getter @Setter @Builder
@AllArgsConstructor @NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class FoodTruck {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private String description;

    private List<Menu> menus;

    private String imageUrl;

}
