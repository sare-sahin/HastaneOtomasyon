package com.sare.service;

import com.sare.config.JwtManager;
import com.sare.dto.request.LoginRequestDto;
import com.sare.dto.request.RegisterRequestDto;
import com.sare.entity.Hasta;
import com.sare.exception.ErrorType;
import com.sare.exception.HastaneOtomasyonException;
import com.sare.mapper.HastaMapper;
import com.sare.repository.HastaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HastaService {
    private final HastaRepository hastaRepository;
    private final JwtManager jwtManager;


    public void hastaEkle(RegisterRequestDto dto) {
        Hasta hasta = HastaMapper.INSTANCE.fromRegisterRequestDto(dto);
        hastaRepository.save(hasta);
    }


    public String hastaGirisi(LoginRequestDto dto) {
        Optional<Hasta> hasta = hastaRepository.findOptionalByEmailAndSifre(dto.email(),dto.sifre());
        if(hasta.isEmpty()) throw new HastaneOtomasyonException(ErrorType.EMAILSIFREHATASI);
        return jwtManager.createToken(hasta.get().getId());
    }


    public Optional<Hasta> hastaBulIdyeGore(Long hastaId) {
        return hastaRepository.findById(hastaId);
    }


}