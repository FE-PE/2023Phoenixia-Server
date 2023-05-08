package com.Fepe.PhoenixiaServer.foodtruck;

import com.Fepe.PhoenixiaServer.Menu.Menu;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter @Builder
@AllArgsConstructor @NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class FoodTruck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FOODTRUCK_ID")
    private Integer truck_id;

    private String name;

    private String description;

    @JsonManagedReference
    @OneToMany(mappedBy = "foodTruck", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Menu> menus = new ArrayList<>();

    private String imageUrl;

}
