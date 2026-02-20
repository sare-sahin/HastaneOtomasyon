package com.sare.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record MuayeneEkleRequestDto(
        @NotNull(message = "Hasta ID bos olamaz.")
        Long hastaId,

        @NotNull(message = "Doktor ID bos olamaz.")
        Long doktorId,

        @NotNull(message = "Muayene yapildi mi bilgisi zorunludur.")
        Boolean muayeneYapildiMi,

        @Size(max = 1000, message = "Hastalik oykusu en fazla 1000 karakter olabilir.")
        String hastalikOykusu,

        @Size(max = 255, message = "Tani en fazla 255 karakter olabilir.")
        String tani,

        Long receteNo
) { }
