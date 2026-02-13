package com.sare.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

public record RandevuEkleRequestDto(
        @NotNull(message = "Hasta ID bos olamaz.")
        Long hastaId,

        @NotNull(message = "Doktor ID bos olamaz.")
        Long doktorId,

        @NotNull(message = "Tarih bos olamaz.")
        @FutureOrPresent(message = "Randevu tarihi gecmis olamaz.")
        String randevuTarihi,

        @NotNull(message = "Saat bos olamaz.")
        @Schema(type = "string", pattern = "HH:mm", example = "14:30")
        String randevuSaati
) {}

