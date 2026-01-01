package com.sare.dto.request;

import com.sare.utility.Cinsiyet;

public record RegisterRequestDto(
        String ad,
        String soyad,
        String email,
        String sifre,
        String telefon,
        String adres,
        String tckimlik,
        Integer yas,
        Cinsiyet cinsiyet
) {
}
