package com.sare.service;

import com.sare.config.JwtManager;
import com.sare.dto.request.LoginRequestDto;
import com.sare.dto.request.RegisterRequestDto;
import com.sare.entity.Kullanici;
import com.sare.exception.ErrorType;
import com.sare.exception.HastaneOtomasyonException;
import com.sare.mapper.KullaniciMapper;
import com.sare.repository.KullaniciRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class KullaniciService {
    private final KullaniciRepository kullaniciRepository;
    private final JwtManager jwtManager;


    public void kullaniciEkle(RegisterRequestDto dto) {
        Kullanici kullanici = KullaniciMapper.INSTANCE.fromRegisterRequestDto(dto);
        kullaniciRepository.save(kullanici);
    }


    public String kullaniciGirisi(LoginRequestDto dto) {
        Optional<Kullanici> kullanici = kullaniciRepository.findOptionalByEmailAndSifre(dto.email(),dto.sifre());
        if(kullanici.isEmpty()) throw new HastaneOtomasyonException(ErrorType.EMAILSIFREHATASI);
        return jwtManager.createToken(kullanici.get().getId());
    }


    public Optional<Kullanici> kullaniciBulIdyeGore(Long kullaniciId) {
        return kullaniciRepository.findById(kullaniciId);
    }


}