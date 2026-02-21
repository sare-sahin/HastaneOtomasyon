package com.sare.service;

import com.sare.dto.request.DoktorEkleRequestDto;
import com.sare.entity.Doktor;
import com.sare.mapper.DoktorMapper;
import com.sare.repository.DoktorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DoktorService {
    private final DoktorRepository doktorRepository;

    public void doktorEkle(DoktorEkleRequestDto dto) {
        Doktor doktor = DoktorMapper.INSTANCE.fromDoktorEkleRequestDto(dto);
        doktorRepository.save(doktor);
    }
}
