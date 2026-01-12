package com.sare.dto.request;

import com.sare.utility.Roller;

public record RolEkleRequestDto (
        Long kullaniciId,
        Roller roller
){
}
