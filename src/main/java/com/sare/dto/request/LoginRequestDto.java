package com.sare.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LoginRequestDto(
        @Email(message = "Gecerli bir email giriniz.")
        @NotBlank(message = "Email bos olamaz.")
        String email,

        @NotBlank(message = "Sifre bos olamaz.")
        @Size(min = 6, message = "Sifre en az 6 karakter olmalidir.")
        String sifre
) {}