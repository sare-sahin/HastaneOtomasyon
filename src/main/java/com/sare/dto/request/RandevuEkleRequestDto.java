package com.sare.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;

public record RandevuEkleRequestDto(
        @NotNull(message = "Kullanici ID bos olamaz.")
        Long kullaniciId,

        @NotNull(message = "Doktor ID bos olamaz.")
        Long doktorId,

        @NotNull(message = "Tarih bos olamaz.")
        @FutureOrPresent(message = "Randevu tarihi gecmis olamaz.")
        LocalDate localDate,

        @NotNull(message = "Saat bos olamaz.")
        @Schema(type = "string", pattern = "HH:mm", example = "14:30")
        LocalTime localTime
) {}

