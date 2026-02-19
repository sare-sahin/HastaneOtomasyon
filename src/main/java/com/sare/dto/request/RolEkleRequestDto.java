package com.sare.dto.request;

import com.sare.utility.Roller;
import jakarta.validation.constraints.NotNull;

public record RolEkleRequestDto (
        @NotNull(message = "Hasta ID boş olamaz.")
        Long hastaId,

        @NotNull(message = "Rol bilgisi bos olamaz.")
        Roller roller
){ }
