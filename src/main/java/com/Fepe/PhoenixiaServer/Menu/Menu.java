package com.Fepe.PhoenixiaServer.Menu;

import com.Fepe.PhoenixiaServer.foodtruck.FoodTruck;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter @Builder
@AllArgsConstructor @NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Menu {

    @Id
    @GeneratedValue
    @Column(name = "MENU_ID")
    private Integer id;

    private String name;

    private Integer price;

    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "FOODTRUCK_ID")
    private FoodTruck foodTruck;
}
