package com.sare.dto.request;

import com.sare.utility.Cinsiyet;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record RegisterRequestDto(
        @NotBlank(message = "Ad bos olamaz.")
        String ad,

        @NotBlank(message = "Soyad bos olamaz.")
        String soyad,

        @Email(message = "Gecerli bir email giriniz.")
        @NotBlank(message = "Email bos olamaz.")
        String email,

        @NotBlank(message = "Sifre bos olamaz.")
        @Size(min = 6, message = "Sifre en az 6 karakter olmalidir.")
        String sifre,

        @NotBlank(message = "Telefon bos olamaz.")
        String telefon,

        @NotBlank(message = "TC Kimlik bos olamaz.")
        @Size(min = 11, max = 11, message = "TC Kimlik 11 haneli olmalidir.")
        String tckimlik,

        @NotBlank(message = "İl bos olamaz.")
        String il,

        @NotBlank(message = "İlce bos olamaz.")
        String ilce,

        @NotBlank(message = "Adres bos olamaz.")
        String adres,

        @NotNull(message = "Yas bos olamaz.")
        Integer yas,

        @NotNull(message = "Cinsiyet bilgisi bos olamaz.")
        Cinsiyet cinsiyet,

        String yakini,
        String yakiniTelefon
) { }
