package com.sare.controller;

import com.sare.service.KullaniciService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.sare.config.RestApis.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(KULLANICI)
@CrossOrigin
@SecurityRequirement(name = "bearerAuth")
public class KullaniciController {
    private final KullaniciService kullaniciService;
}
