package com.Fepe.PhoenixiaServer.club;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data @Builder
@Getter @Setter
public class ClubDto {

    private Integer number;

    private String name;

    private String description;

}
