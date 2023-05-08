package com.Fepe.PhoenixiaServer.club;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class ClubDto {

    private Integer number;
    private String imageUrl;
    private String category;

    private String name;

    private String description;

}
