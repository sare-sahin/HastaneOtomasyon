package com.sare.service;

import com.sare.dto.request.RegisterRequestDto;
import com.sare.entity.Kullanici;
import com.sare.mapper.KullaniciMapper;
import com.sare.repository.KullaniciRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KullaniciService {
    private final KullaniciRepository kullaniciRepository;


    public void kullaniciEkle(RegisterRequestDto dto) {
        Kullanici kullanici = KullaniciMapper.INSTANCE.fromRegisterRequestDto(dto);
        kullaniciRepository.save(kullanici);
    }
}