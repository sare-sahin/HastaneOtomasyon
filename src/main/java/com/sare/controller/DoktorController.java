package com.sare.controller;

import com.sare.dto.request.DoktorEkleRequestDto;
import com.sare.dto.response.BaseResponse;
import com.sare.service.DoktorService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static com.sare.config.RestApis.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(DOKTOR)
@CrossOrigin
@SecurityRequirement(name = "bearerAuth")
public class DoktorController {
    private final DoktorService doktorService;

    @PostMapping(DOKTOREKLE)
    public ResponseEntity<BaseResponse<Boolean>> doktorEkle(@RequestBody DoktorEkleRequestDto dto) {
        doktorService.doktorEkle(dto);
        return ResponseEntity.ok(BaseResponse.<Boolean>builder()
                .code(200)
                .message("Doktor başarı ile eklendi.")
                .data(true)
                .build());
    }

}
