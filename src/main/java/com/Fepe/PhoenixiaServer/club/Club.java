package com.Fepe.PhoenixiaServer.club;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity
@Getter @Setter @Builder
@AllArgsConstructor @NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Club {

    @GeneratedValue
    private Integer id;

    private Integer number;

    private String name;

    private String description;
}
