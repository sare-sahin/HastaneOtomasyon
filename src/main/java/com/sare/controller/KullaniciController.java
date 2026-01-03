package com.sare.controller;

import com.sare.dto.request.RegisterRequestDto;
import com.sare.dto.response.BaseResponse;
import com.sare.service.KullaniciService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static com.sare.config.RestApis.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(KULLANICI)
@CrossOrigin
@SecurityRequirement(name = "bearerAuth")
public class KullaniciController {
    private final KullaniciService kullaniciService;

    @PostMapping(REGISTER)
    public ResponseEntity<BaseResponse<Boolean>> register(@RequestBody RegisterRequestDto dto){
        kullaniciService.kullaniciEkle(dto);
        return ResponseEntity.ok(BaseResponse.<Boolean>builder()
                .code(200)
                .message("Yeni üye başarı ile kaydedildi.")
                .data(true)
                .build());
    }
}
