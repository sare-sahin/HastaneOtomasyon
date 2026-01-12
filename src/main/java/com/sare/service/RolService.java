package com.sare.service;

import com.sare.dto.request.RolEkleRequestDto;
import com.sare.entity.Rol;
import com.sare.repository.RolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RolService {
    private final RolRepository rolRepository;


    public void rolEkle(RolEkleRequestDto dto){
        rolRepository.save(Rol.builder()
                .kullaniciId(dto.kullaniciId())
                .roller(dto.roller())
                .build());
    }


    public List<Rol> rolBulKullaniciIdyeGore(Long kullaniciId) {
        return rolRepository.findAllRolByKullaniciId(kullaniciId);
    }


}
