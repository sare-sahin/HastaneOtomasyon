package com.sare.service;

import com.sare.repository.KullaniciRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KullaniciService {
    private final KullaniciRepository kullaniciRepository;
}
