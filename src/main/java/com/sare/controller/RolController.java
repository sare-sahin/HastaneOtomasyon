package com.sare.controller;

import com.sare.dto.request.RolEkleRequestDto;
import com.sare.dto.response.BaseResponse;
import com.sare.service.RolService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static com.sare.config.RestApis.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(ROL)
@CrossOrigin
@SecurityRequirement(name = "bearerAuth")
public class RolController {
    private final RolService rolService;


    @PostMapping(ROLEKLE)
    public ResponseEntity<BaseResponse<Boolean>> rolEkle(@RequestBody RolEkleRequestDto dto){
        rolService.rolEkle(dto);
        return ResponseEntity.ok(BaseResponse.<Boolean>builder()
                .code(200)
                .message("Rol başarı ile eklendi.")
                .data(true)
                .build());
    }

}