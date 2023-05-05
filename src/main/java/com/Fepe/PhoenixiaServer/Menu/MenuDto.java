package com.Fepe.PhoenixiaServer.Menu;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class MenuDto {

    private String name;

    private Integer price;

    private String imageUrl;

}
