package com.Fepe.PhoenixiaServer.foodtruck;

import com.Fepe.PhoenixiaServer.Menu.Menu;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter @Builder
@AllArgsConstructor @NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class FoodTruck {

    @Id
    @GeneratedValue
    @Column(name = "FOODTRUCK_ID")
    private Integer id;

    private String name;

    private String description;

    @OneToMany(mappedBy = "foodTruck")
    private List<Menu> menus = new ArrayList<>();

    private String imageUrl;

}
