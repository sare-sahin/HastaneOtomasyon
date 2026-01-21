package com.sare.service;

import com.sare.dto.request.RandevuEkleRequestDto;
import com.sare.entity.Randevu;
import com.sare.mapper.RandevuMapper;
import com.sare.repository.RandevuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RandevuService {
    private final RandevuRepository randevuRepository;

    public void randevuEkle(RandevuEkleRequestDto dto) {
        Randevu randevu = RandevuMapper.INSTANCE.fromRandevuEkleRequestDto(dto);
        randevuRepository.save(randevu);
    }
}
