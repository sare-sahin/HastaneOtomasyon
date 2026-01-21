package com.sare.controller;

import com.sare.dto.request.RandevuEkleRequestDto;
import com.sare.dto.response.BaseResponse;
import com.sare.service.RandevuService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static com.sare.config.RestApis.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(RANDEVU)
@CrossOrigin
@SecurityRequirement(name = "bearerAuth")
public class RandevuController {
    private final RandevuService randevuService;

    @PostMapping(RANDEVUEKLE)
    public ResponseEntity<BaseResponse<Boolean>> randevuEkle(@RequestBody RandevuEkleRequestDto dto) {
        randevuService.randevuEkle(dto);
        return ResponseEntity.ok(BaseResponse.<Boolean>builder()
                .code(200)
                .message("Randevu başarı ile oluşturuldu.")
                .data(true)
                .build());
    }

}
