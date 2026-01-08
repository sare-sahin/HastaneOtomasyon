package com.sare.repository;

import com.sare.entity.Kullanici;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface KullaniciRepository extends JpaRepository<Kullanici, Long> {

        Optional<Kullanici> findOptionalByEmailAndSifre(String email, String sifre);

}
