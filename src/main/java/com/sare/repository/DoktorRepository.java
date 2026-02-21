package com.sare.repository;

import com.sare.entity.Doktor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoktorRepository extends JpaRepository<Doktor, Long> {
}
