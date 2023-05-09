package com.Fepe.PhoenixiaServer.Menu;

import com.Fepe.PhoenixiaServer.foodtruck.FoodTruck;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter @Builder
@AllArgsConstructor @NoArgsConstructor
@EqualsAndHashCode(of = "menu_id")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MENU_ID")
    private Integer menu_id;

    private String name;

    private Integer price;

    private String imageUrl;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "FOODTRUCK_ID")
    private FoodTruck foodTruck;
}
