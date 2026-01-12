package com.sare.entity;

import com.sare.utility.Roller;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tblrol")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long kullaniciId;
    Roller roller;
}