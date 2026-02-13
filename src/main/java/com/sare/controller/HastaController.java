package com.sare.controller;

import com.sare.dto.request.LoginRequestDto;
import com.sare.dto.request.RegisterRequestDto;
import com.sare.dto.response.BaseResponse;
import com.sare.service.HastaService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static com.sare.config.RestApis.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(HASTA)
@CrossOrigin
@SecurityRequirement(name = "bearerAuth")
public class HastaController {
    private final HastaService hastaService;

    @PostMapping(REGISTER)
    public ResponseEntity<BaseResponse<Boolean>> register(@RequestBody RegisterRequestDto dto){
        hastaService.hastaEkle(dto);
        return ResponseEntity.ok(BaseResponse.<Boolean>builder()
                .code(200)
                .message("Yeni hasta başarı ile kaydedildi.")
                .data(true)
                .build());
    }


    @PostMapping(LOGIN)
    public ResponseEntity<BaseResponse<String>> login(@RequestBody LoginRequestDto dto){
        String token = hastaService.hastaGirisi(dto);
        return ResponseEntity.ok(BaseResponse.<String>builder()
                .code(200)
                .message("Hasta girişi başarı ile yapıldı.")
                .data(token)
                .build());
    }
}
