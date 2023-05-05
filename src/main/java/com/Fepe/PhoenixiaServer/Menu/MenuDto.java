package com.Fepe.PhoenixiaServer.Menu;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data @Builder
@Getter @Setter
public class MenuDto {

    private String name;

    private Integer price;

    private String imageUrl;

}
