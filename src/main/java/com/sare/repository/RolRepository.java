package com.sare.repository;

import com.sare.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RolRepository extends JpaRepository<Rol, Long> {

    List<Rol> findAllRolByHastaId(Long hastaId);
}
