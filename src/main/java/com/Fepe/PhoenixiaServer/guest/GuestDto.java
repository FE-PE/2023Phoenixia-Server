package com.Fepe.PhoenixiaServer.guest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class GuestDto {
    private String nickname;
    private String content;
}
