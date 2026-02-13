package com.sare.repository;

import com.sare.entity.Hasta;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface HastaRepository extends JpaRepository<Hasta, Long> {

        Optional<Hasta> findOptionalByEmailAndSifre(String email, String sifre);

}
