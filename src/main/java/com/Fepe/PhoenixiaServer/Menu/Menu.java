package com.Fepe.PhoenixiaServer.Menu;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter @Builder
@AllArgsConstructor @NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Menu {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private Integer price;

    private String imageUrl;
}
